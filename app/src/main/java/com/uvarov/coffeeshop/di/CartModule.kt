package com.uvarov.coffeeshop.di

import com.uvarov.coffeeshop.common.data.cart.CartDataSource
import com.uvarov.coffeeshop.common.data.cart.CartDataSourceImpl
import com.uvarov.coffeeshop.common.data.cart.CartRepositoryImpl
import com.uvarov.coffeeshop.common.domain.cart.CartRepository
import com.uvarov.coffeeshop.common.domain.cart.GetCartProductsUseCase
import com.uvarov.coffeeshop.common.domain.cart.GetCartProductsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CartModule {

    @Provides
    @Singleton
    fun provideCartDataSource(): CartDataSource {
        return CartDataSourceImpl()
    }

    @Provides
    fun provideCartRepository(
        dataSource: CartDataSource,
    ): CartRepository {
        return CartRepositoryImpl(dataSource)
    }

    @Provides
    fun provideGetAllCartProductsUseCase(
        repository: CartRepository,
    ): GetCartProductsUseCase {
        return GetCartProductsUseCaseImpl(repository)
    }

//    @Provides
//    fun provideIsFavoriteUseCase(
//        repository: FavoritesRepository,
//    ): IsFavoriteUseCase {
//        return IsFavoriteUseCaseImpl(repository)
//    }
//
//    @Provides
//    fun provideToggleFavoriteUseCase(
//        repository: FavoritesRepository,
//    ): ToggleFavoriteUseCase {
//        return ToggleFavoriteUseCaseImpl(repository)
//    }
}