package com.uvarov.coffeeshop.features.productDetail.presentation

import com.uvarov.coffeeshop.common.domain.product.Product
import com.uvarov.coffeeshop.common.domain.product.ProductVariant

sealed class ProductDetailState {
    object Loading : ProductDetailState()

    data class Success(
        val product: Product,
        val isFavorite: Boolean,
        val selectedVariant: ProductVariant,
    ) : ProductDetailState()

    data class Error(val message: String) : ProductDetailState()
}