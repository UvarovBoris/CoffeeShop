package com.example.coffeeshop.features.productDetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeshop.domain.GetProductUseCase
import com.example.coffeeshop.domain.ProductVariant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getProductUseCase: GetProductUseCase,
) : ViewModel() {

    private val product = savedStateHandle
        .getStateFlow("productId", -1)
        .flatMapConcat { getProductUseCase(it) }

    private val selectedVariant = MutableStateFlow<ProductVariant?>(null)

    val state: StateFlow<ProductDetailState> = combine(
        product, selectedVariant,
    ) { product, selectedVariant ->
        ProductDetailState.Success(
            product = product,
            selectedVariant = selectedVariant ?: product.variants.first()
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        ProductDetailState.Loading
    )

    fun onVariantSelect(variant: ProductVariant) {
        selectedVariant.value = variant
    }
}