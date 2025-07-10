package com.example.coffeeshop.di

import android.content.Context
import com.example.coffeeshop.data.AppDataStore
import com.example.coffeeshop.data.AppDataStoreImpl
import com.example.coffeeshop.data.ProductsDataSource
import com.example.coffeeshop.data.ProductsDataSourceImpl
import com.example.coffeeshop.data.ProductsRepositoryImpl
import com.example.coffeeshop.data.SettingsRepository
import com.example.coffeeshop.data.SettingsRepositoryImpl
import com.example.coffeeshop.domain.GetAllProductsUseCase
import com.example.coffeeshop.domain.GetAllProductsUseCaseImpl
import com.example.coffeeshop.domain.GetProductUseCase
import com.example.coffeeshop.domain.GetProductUseCaseImpl
import com.example.coffeeshop.domain.ProductsRepository
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