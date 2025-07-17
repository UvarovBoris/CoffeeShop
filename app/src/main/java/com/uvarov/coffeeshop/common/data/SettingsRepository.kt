package com.uvarov.coffeeshop.common.data

import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    val isOnboardingDone: Flow<Boolean>
    suspend fun setOnboardingDone(isDone: Boolean)
}

class SettingsRepositoryImpl(
    private val dataStore: AppDataStore,
) : SettingsRepository {

    override val isOnboardingDone: Flow<Boolean>
        get() = dataStore.isOnboardingDone

    override suspend fun setOnboardingDone(isDone: Boolean) {
        dataStore.setOnboardingDone(isDone)
    }
}