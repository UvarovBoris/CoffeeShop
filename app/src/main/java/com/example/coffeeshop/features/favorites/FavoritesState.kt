package com.example.coffeeshop.features.favorites

import com.example.coffeeshop.data.ProductData

sealed class FavoritesState {
    object Loading : FavoritesState()

    data class Success(
        val products: List<ProductData>,
    ) : FavoritesState()

    data class Error(val message: String) : FavoritesState()
}