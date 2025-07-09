package com.example.coffeeshop.features.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeshop.data.allProducts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow<FavoritesState>(FavoritesState.Loading)
    val uiState: StateFlow<FavoritesState> = _uiState

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            delay(1000) // simulate work
            _uiState.value = FavoritesState.Success(allProducts)
            // _uiState.value = MyScreenState.Error("Something went wrong")
        }
    }
}