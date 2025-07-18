package com.uvarov.coffeeshop.common.domain.favorites

import kotlinx.coroutines.flow.Flow

interface GetAllFavoritesUseCase {
    operator fun invoke(): Flow<Set<Int>>
}

class GetAllFavoritesUseCaseImpl(
    private val favoritesRepository: FavoritesRepository,
) : GetAllFavoritesUseCase {

    override operator fun invoke(): Flow<Set<Int>> {
        return favoritesRepository.getAllFavorites()
    }
}