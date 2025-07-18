package com.uvarov.coffeeshop.common.domain.favorites

import kotlinx.coroutines.flow.Flow

interface IsFavoriteUseCase {
    operator fun invoke(id: Int): Flow<Boolean>
}

class IsFavoriteUseCaseImpl(
    private val favoritesRepository: FavoritesRepository,
) : IsFavoriteUseCase {

    override operator fun invoke(id: Int): Flow<Boolean> {
        return favoritesRepository.isFavorite(id)
    }
}