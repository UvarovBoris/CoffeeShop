package com.uvarov.coffeeshop.features.favorites.presentation

import com.uvarov.coffeeshop.common.domain.product.Product

sealed class FavoritesState {
    object Loading : FavoritesState()

    data class Success(
        val products: List<Product>,
    ) : FavoritesState()

    data class Error(val message: String) : FavoritesState()
}