package com.example.coffeeshop.features.favorites

import com.example.coffeeshop.domain.Product

sealed class FavoritesState {
    object Loading : FavoritesState()

    data class Success(
        val products: List<Product>,
    ) : FavoritesState()

    data class Error(val message: String) : FavoritesState()
}