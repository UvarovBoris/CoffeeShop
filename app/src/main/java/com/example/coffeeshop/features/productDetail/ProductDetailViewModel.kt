package com.example.coffeeshop.features.productDetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeshop.domain.GetProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getProductUseCase: GetProductUseCase
) : ViewModel() {
    private val _state = MutableStateFlow<ProductDetailState>(ProductDetailState.Loading)
    val state: StateFlow<ProductDetailState> = _state

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            val productId = savedStateHandle.get<Int>("productId") ?: -1
            val product = getProductUseCase(productId).first()
            _state.value = ProductDetailState.Success(product)
        }
    }
}