package com.example.coffeeshop.di

import com.example.coffeeshop.data.ProductsRepositoryImpl
import com.example.coffeeshop.domain.GetAllProductsUseCase
import com.example.coffeeshop.domain.GetAllProductsUseCaseImpl
import com.example.coffeeshop.domain.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideProductsRepository(): ProductsRepository {
        return ProductsRepositoryImpl()
    }

    @Provides
    fun provideGetAllProductsUseCase(
        repository: ProductsRepository,
    ): GetAllProductsUseCase {
        return GetAllProductsUseCaseImpl(repository)
    }
}