package com.uvarov.coffeeshop.features.productDetail

import com.uvarov.coffeeshop.domain.Product
import com.uvarov.coffeeshop.domain.ProductVariant

sealed class ProductDetailState {
    object Loading : ProductDetailState()

    data class Success(
        val product: Product,
        val selectedVariant: ProductVariant,
    ) : ProductDetailState()

    data class Error(val message: String) : ProductDetailState()
}