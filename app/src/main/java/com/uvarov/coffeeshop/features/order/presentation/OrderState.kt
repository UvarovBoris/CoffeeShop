package com.uvarov.coffeeshop.features.order.presentation

import com.uvarov.coffeeshop.common.domain.product.Product

sealed class OrderState {
    data object Loading : OrderState()

    data class Success(
        val products: Map<Product, Int>
    ) : OrderState()

    data class Error(val message: String) : OrderState()
}