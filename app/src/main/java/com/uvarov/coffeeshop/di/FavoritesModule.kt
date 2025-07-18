package com.uvarov.coffeeshop.di

import com.uvarov.coffeeshop.common.data.favorites.FavoritesDataSource
import com.uvarov.coffeeshop.common.data.favorites.FavoritesDataSourceImpl
import com.uvarov.coffeeshop.common.data.favorites.FavoritesRepositoryImpl
import com.uvarov.coffeeshop.common.domain.favorites.FavoritesRepository
import com.uvarov.coffeeshop.common.domain.favorites.GetAllFavoritesUseCase
import com.uvarov.coffeeshop.common.domain.favorites.GetAllFavoritesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FavoritesModule {

    @Provides
    fun provideFavoritesDataSource(): FavoritesDataSource {
        return FavoritesDataSourceImpl()
    }

    @Provides
    fun provideFavoritesRepository(
        dataSource: FavoritesDataSource,
    ): FavoritesRepository {
        return FavoritesRepositoryImpl(dataSource)
    }

    @Provides
    fun provideGetAllFavoritesUseCase(
        repository: FavoritesRepository,
    ): GetAllFavoritesUseCase {
        return GetAllFavoritesUseCaseImpl(repository)
    }
}