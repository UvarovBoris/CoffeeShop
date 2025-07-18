package com.uvarov.coffeeshop.common.data.favorites

import com.uvarov.coffeeshop.common.domain.favorites.FavoritesRepository
import kotlinx.coroutines.flow.Flow

class FavoritesRepositoryImpl(
    private val favoritesDataSource: FavoritesDataSource,
) : FavoritesRepository {

    override fun getAllFavorites(): Flow<Set<Int>> {
        return favoritesDataSource.getAllFavorites()
    }

    override suspend fun addFavorite(id: Int) {
        favoritesDataSource.addFavorite(id)
    }

    override suspend fun removeFavorite(id: Int) {
        favoritesDataSource.removeFavorite(id)
    }
}