package com.uvarov.coffeeshop.features.cart.presentation

import com.uvarov.coffeeshop.common.domain.product.Product

sealed class CartState {
    data object Loading : CartState()

    data class Success(
        val products: Map<Product, Int>
    ) : CartState()

    data class Error(val message: String) : CartState()
}