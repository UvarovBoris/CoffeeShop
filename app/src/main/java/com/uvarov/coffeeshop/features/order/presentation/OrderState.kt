package com.uvarov.coffeeshop.features.order.presentation

sealed class OrderState {
    object Loading : OrderState()

    object Success : OrderState()

    data class Error(val message: String) : OrderState()
}