package com.uvarov.coffeeshop.common.domain.favorites

import kotlinx.coroutines.flow.first

interface ToggleFavoriteUseCase {
    suspend operator fun invoke(id: Int)
}

class ToggleFavoriteUseCaseImpl(
    private val favoritesRepository: FavoritesRepository,
) : ToggleFavoriteUseCase {

    override suspend operator fun invoke(id: Int) {
        val isFavorite = favoritesRepository.isFavorite(id).first()
        if (isFavorite) {
            favoritesRepository.removeFavorite(id)
        } else {
            favoritesRepository.addFavorite(id)
        }
    }
}