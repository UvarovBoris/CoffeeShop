package com.example.coffeeshop.features.productDetail

import com.example.coffeeshop.domain.Product
import com.example.coffeeshop.domain.ProductVariant

sealed class ProductDetailState {
    object Loading : ProductDetailState()

    data class Success(
        val product: Product,
        val selectedVariant: ProductVariant,
    ) : ProductDetailState()

    data class Error(val message: String) : ProductDetailState()
}