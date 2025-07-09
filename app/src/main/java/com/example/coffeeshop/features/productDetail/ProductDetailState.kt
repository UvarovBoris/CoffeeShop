package com.example.coffeeshop.features.productDetail

import com.example.coffeeshop.domain.Product

sealed class ProductDetailState {
    object Loading : ProductDetailState()

    data class Success(
        val product: Product,
    ) : ProductDetailState()

    data class Error(val message: String) : ProductDetailState()
}