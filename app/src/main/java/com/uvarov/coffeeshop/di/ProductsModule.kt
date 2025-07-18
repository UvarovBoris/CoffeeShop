package com.uvarov.coffeeshop.di

import com.uvarov.coffeeshop.common.data.product.ProductsDataSource
import com.uvarov.coffeeshop.common.data.product.ProductsDataSourceImpl
import com.uvarov.coffeeshop.common.data.product.ProductsRepositoryImpl
import com.uvarov.coffeeshop.common.domain.product.GetProductsUseCase
import com.uvarov.coffeeshop.common.domain.product.GetProductsUseCaseImpl
import com.uvarov.coffeeshop.common.domain.product.GetProductUseCase
import com.uvarov.coffeeshop.common.domain.product.GetProductUseCaseImpl
import com.uvarov.coffeeshop.common.domain.product.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ProductsModule {

    @Provides
    fun provideProductsDataSource(): ProductsDataSource {
        return ProductsDataSourceImpl()
    }

    @Provides
    fun provideProductsRepository(
        dataSource: ProductsDataSource,
    ): ProductsRepository {
        return ProductsRepositoryImpl(dataSource)
    }

    @Provides
    fun provideGetProductsUseCase(
        repository: ProductsRepository,
    ): GetProductsUseCase {
        return GetProductsUseCaseImpl(repository)
    }

    @Provides
    fun provideGetProductUseCase(
        repository: ProductsRepository,
    ): GetProductUseCase {
        return GetProductUseCaseImpl(repository)
    }
}