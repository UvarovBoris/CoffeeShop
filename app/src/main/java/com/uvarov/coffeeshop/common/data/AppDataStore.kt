package com.uvarov.coffeeshop.common.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface AppDataStore {
    val isOnboardingDone: Flow<Boolean>
    suspend fun setOnboardingDone(isDone: Boolean)
}

class AppDataStoreImpl(
    private val context: Context,
) : AppDataStore {

    companion object {
        val IS_ONBOARDING_DONE = booleanPreferencesKey("is_onboarding_done")
    }

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "appDataStore")

    override val isOnboardingDone: Flow<Boolean>
        get() = context.dataStore.data.map { it[IS_ONBOARDING_DONE] ?: false }

    override suspend fun setOnboardingDone(isDone: Boolean) {
        context.dataStore.edit { it[IS_ONBOARDING_DONE] = isDone }
    }
}