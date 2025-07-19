package com.uvarov.coffeeshop.features.productDetail.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uvarov.coffeeshop.common.domain.cart.AddProductToCartUseCase
import com.uvarov.coffeeshop.common.domain.favorites.IsFavoriteUseCase
import com.uvarov.coffeeshop.common.domain.favorites.ToggleFavoriteUseCase
import com.uvarov.coffeeshop.common.domain.product.GetProductUseCase
import com.uvarov.coffeeshop.common.domain.product.ProductSize
import com.uvarov.coffeeshop.common.domain.product.ProductVariant
import com.uvarov.coffeeshop.common.navigation.Order
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getProductUseCase: GetProductUseCase,
    private val isFavoriteUseCase: IsFavoriteUseCase,
    private val toggleFavoriteUseCase: ToggleFavoriteUseCase,
    private val addProductToCartUseCase: AddProductToCartUseCase,
) : ViewModel() {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val product = savedStateHandle
        .getStateFlow("productId", -1)
        .flatMapLatest { getProductUseCase(it) }

    @OptIn(ExperimentalCoroutinesApi::class)
    private val isFavorite = savedStateHandle
        .getStateFlow("productId", -1)
        .flatMapLatest { isFavoriteUseCase(it) }

    private val selectedVariant = MutableStateFlow<ProductVariant?>(null)

    val state: StateFlow<ProductDetailState> = combine(
        product, isFavorite, selectedVariant,
    ) { product, isFavorite, selectedVariant ->
        ProductDetailState.Success(
            product = product,
            isFavorite = isFavorite,
            selectedVariant = selectedVariant
                ?: product.variants.find { it.size == ProductSize.Medium }
                ?: product.variants.first()
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        ProductDetailState.Loading
    )

    private val _navigationEvent = MutableSharedFlow<Any>()
    val navigationEvent: SharedFlow<Any> = _navigationEvent

    fun onFavoriteToggle() {
        viewModelScope.launch {
            val productId = savedStateHandle.get<Int>("productId") ?: return@launch
            toggleFavoriteUseCase(productId)
        }
    }

    fun onVariantSelect(variant: ProductVariant) {
        selectedVariant.value = variant
    }

    fun onBuyClick() {
        viewModelScope.launch {
            val productId = savedStateHandle.get<Int>("productId") ?: return@launch
            addProductToCartUseCase(productId)
            _navigationEvent.emit(Order)
        }
    }
}