package com.uvarov.coffeeshop.features.cart.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uvarov.coffeeshop.common.domain.cart.GetCartProductsUseCase
import com.uvarov.coffeeshop.common.domain.product.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val getCartProductsUseCase: GetCartProductsUseCase,
) : ViewModel() {

    private val productsFlow = getProductsUseCase()
    private val cartProductsFlow = getCartProductsUseCase()

    val state: StateFlow<CartState>
        get() = combine(
            productsFlow,
            cartProductsFlow
        ) { products, cartProducts ->
            val productToQuantity = cartProducts.mapNotNull { (id, quantity) ->
                products.find { it.id == id }?.let { product ->
                    product to quantity
                }
            }.toMap()
            CartState.Success(productToQuantity)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = CartState.Loading
        )
}