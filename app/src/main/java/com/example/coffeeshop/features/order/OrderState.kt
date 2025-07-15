package com.example.coffeeshop.features.order

sealed class OrderState {
    object Loading : OrderState()

    object Success : OrderState()

    data class Error(val message: String) : OrderState()
}