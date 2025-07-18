package com.uvarov.coffeeshop.common.domain.favorites

import kotlinx.coroutines.flow.Flow

interface GetFavoritesUseCase {
    operator fun invoke(): Flow<Set<Int>>
}

class GetFavoritesUseCaseImpl(
    private val favoritesRepository: FavoritesRepository,
) : GetFavoritesUseCase {

    override operator fun invoke(): Flow<Set<Int>> {
        return favoritesRepository.getAllFavorites()
    }
}