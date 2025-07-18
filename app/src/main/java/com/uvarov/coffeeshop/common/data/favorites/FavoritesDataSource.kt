package com.uvarov.coffeeshop.common.data.favorites

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

interface FavoritesDataSource {
    fun getAllFavorites(): Flow<Set<Int>>

    suspend fun addFavorite(id: Int)

    suspend fun removeFavorite(id: Int)
}

class FavoritesDataSourceImpl : FavoritesDataSource {

    private val favorites: MutableStateFlow<Set<Int>> = MutableStateFlow(emptySet())

    override fun getAllFavorites(): Flow<Set<Int>> {
        return favorites
    }

    override suspend fun addFavorite(id: Int) {
        favorites.update {
            it + id
        }
    }

    override suspend fun removeFavorite(id: Int) {
        favorites.update {
            it - id
        }
    }
}