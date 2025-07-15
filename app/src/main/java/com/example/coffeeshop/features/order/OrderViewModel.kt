package com.example.coffeeshop.features.order

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
) : ViewModel() {

    private val _state: StateFlow<OrderState> = MutableStateFlow(OrderState.Success)
    val state: StateFlow<OrderState> get() = _state
}