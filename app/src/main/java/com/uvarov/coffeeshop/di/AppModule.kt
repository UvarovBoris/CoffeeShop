package com.uvarov.coffeeshop.di

import android.content.Context
import com.uvarov.coffeeshop.data.AppDataStore
import com.uvarov.coffeeshop.data.AppDataStoreImpl
import com.uvarov.coffeeshop.data.ProductsDataSource
import com.uvarov.coffeeshop.data.ProductsDataSourceImpl
import com.uvarov.coffeeshop.data.ProductsRepositoryImpl
import com.uvarov.coffeeshop.data.SettingsRepository
import com.uvarov.coffeeshop.data.SettingsRepositoryImpl
import com.uvarov.coffeeshop.domain.GetAllProductsUseCase
import com.uvarov.coffeeshop.domain.GetAllProductsUseCaseImpl
import com.uvarov.coffeeshop.domain.GetProductUseCase
import com.uvarov.coffeeshop.domain.GetProductUseCaseImpl
import com.uvarov.coffeeshop.domain.ProductsRepository
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