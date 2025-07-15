package com.example.coffeeshop.features.productDetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeshop.domain.GetProductUseCase
import com.example.coffeeshop.domain.ProductSize
import com.example.coffeeshop.domain.ProductVariant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getProductUseCase: GetProductUseCase,
) : ViewModel() {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val product = savedStateHandle
        .getStateFlow("productId", -1)
        .flatMapLatest { getProductUseCase(it) }

    private val selectedVariant = MutableStateFlow<ProductVariant?>(null)

    val state: StateFlow<ProductDetailState> = combine(
        product, selectedVariant,
    ) { product, selectedVariant ->
        ProductDetailState.Success(
            product = product,
            selectedVariant = selectedVariant
                ?: product.variants.find { it.size == ProductSize.Medium }
                ?: product.variants.first()
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