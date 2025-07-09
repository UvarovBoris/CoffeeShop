package com.example.coffeeshop.features.home

import com.example.coffeeshop.data.ProductData

sealed class HomeState {
    object Loading : HomeState()

    data class Success(
        val products: List<ProductData>,
    ) : HomeState()

    data class Error(val message: String) : HomeState()
}