package com.uvarov.coffeeshop.di

import android.content.Context
import com.uvarov.coffeeshop.common.data.AppDataStore
import com.uvarov.coffeeshop.common.data.AppDataStoreImpl
import com.uvarov.coffeeshop.common.data.SettingsRepository
import com.uvarov.coffeeshop.common.data.SettingsRepositoryImpl
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