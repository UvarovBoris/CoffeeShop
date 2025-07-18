package com.uvarov.coffeeshop.common.domain.favorites

import kotlinx.coroutines.flow.Flow

interface FavoritesRepository {
    fun getAllFavorites(): Flow<Set<Int>>

    suspend fun addFavorite(id: Int)

    suspend fun removeFavorite(id: Int)
}