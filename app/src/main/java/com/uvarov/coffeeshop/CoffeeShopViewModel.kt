package com.uvarov.coffeeshop

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uvarov.coffeeshop.common.data.SettingsRepository
import com.uvarov.coffeeshop.common.navigation.Main
import com.uvarov.coffeeshop.common.navigation.Onboarding
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoffeeShopViewModel @Inject constructor(
    settingsRepository: SettingsRepository,
) : ViewModel() {

    private val _startDestinationState = MutableStateFlow<Any?>(null)
    val startDestinationState = _startDestinationState

    init {
        viewModelScope.launch {
            val isOnboardingDone = settingsRepository.isOnboardingDone.first()
            _startDestinationState.value = if (isOnboardingDone) Main else Onboarding
        }
    }
}