package com.uvarov.coffeeshop.di

import android.content.Context
import com.uvarov.coffeeshop.common.data.AppDataStore
import com.uvarov.coffeeshop.common.data.AppDataStoreImpl
import com.uvarov.coffeeshop.common.data.product.ProductsDataSource
import com.uvarov.coffeeshop.common.data.product.ProductsDataSourceImpl
import com.uvarov.coffeeshop.common.data.product.ProductsRepositoryImpl
import com.uvarov.coffeeshop.common.data.SettingsRepository
import com.uvarov.coffeeshop.common.data.SettingsRepositoryImpl
import com.uvarov.coffeeshop.common.domain.product.GetAllProductsUseCase
import com.uvarov.coffeeshop.common.domain.product.GetAllProductsUseCaseImpl
import com.uvarov.coffeeshop.common.domain.product.GetProductUseCase
import com.uvarov.coffeeshop.common.domain.product.GetProductUseCaseImpl
import com.uvarov.coffeeshop.common.domain.product.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

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
    fun provideGetAllProductsUseCase(
        repository: ProductsRepository,
    ): GetAllProductsUseCase {
        return GetAllProductsUseCaseImpl(repository)
    }

    @Provides
    fun provideGetProductUseCase(
        repository: ProductsRepository,
    ): GetProductUseCase {
        return GetProductUseCaseImpl(repository)
    }

    @Provides
    @Singleton
    fun provideAppDataStore(
        @ApplicationContext context: Context,
    ): AppDataStore {
        return AppDataStoreImpl(context)
    }

    @Provides
    fun provideSettingsRepository(
        appDataStore: AppDataStore,
    ): SettingsRepository {
        return SettingsRepositoryImpl(appDataStore)
    }
}