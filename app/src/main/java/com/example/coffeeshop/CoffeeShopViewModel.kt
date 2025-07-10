package com.example.coffeeshop

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeshop.data.SettingsRepository
import com.example.coffeeshop.navigation.Main
import com.example.coffeeshop.navigation.Onboarding
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