package com.uvarov.coffeeshop.di

import com.uvarov.coffeeshop.common.data.favorites.FavoritesDataSource
import com.uvarov.coffeeshop.common.data.favorites.FavoritesDataSourceImpl
import com.uvarov.coffeeshop.common.data.favorites.FavoritesRepositoryImpl
import com.uvarov.coffeeshop.common.domain.favorites.FavoritesRepository
import com.uvarov.coffeeshop.common.domain.favorites.GetFavoritesUseCase
import com.uvarov.coffeeshop.common.domain.favorites.GetFavoritesUseCaseImpl
import com.uvarov.coffeeshop.common.domain.favorites.IsFavoriteUseCase
import com.uvarov.coffeeshop.common.domain.favorites.IsFavoriteUseCaseImpl
import com.uvarov.coffeeshop.common.domain.favorites.ToggleFavoriteUseCase
import com.uvarov.coffeeshop.common.domain.favorites.ToggleFavoriteUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FavoritesModule {

    @Provides
    @Singleton
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
    fun provideGetFavoritesUseCase(
        repository: FavoritesRepository,
    ): GetFavoritesUseCase {
        return GetFavoritesUseCaseImpl(repository)
    }

    @Provides
    fun provideIsFavoriteUseCase(
        repository: FavoritesRepository,
    ): IsFavoriteUseCase {
        return IsFavoriteUseCaseImpl(repository)
    }

    @Provides
    fun provideToggleFavoriteUseCase(
        repository: FavoritesRepository,
    ): ToggleFavoriteUseCase {
        return ToggleFavoriteUseCaseImpl(repository)
    }
}