package com.uvarov.coffeeshop.common.domain.favorites

import kotlinx.coroutines.flow.Flow

interface FavoritesRepository {
    fun getAllFavorites(): Flow<Set<Int>>

    fun isFavorite(id: Int): Flow<Boolean>

    suspend fun addFavorite(id: Int)

    suspend fun removeFavorite(id: Int)
}