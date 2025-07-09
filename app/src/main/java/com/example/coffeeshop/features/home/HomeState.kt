package com.example.coffeeshop.features.home

import com.example.coffeeshop.domain.Product

sealed class HomeState {
    object Loading : HomeState()

    data class Success(
        val products: List<Product>,
    ) : HomeState()

    data class Error(val message: String) : HomeState()
}