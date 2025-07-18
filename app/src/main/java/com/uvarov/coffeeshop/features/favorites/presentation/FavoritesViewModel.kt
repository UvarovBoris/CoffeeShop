package com.uvarov.coffeeshop.features.favorites.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uvarov.coffeeshop.common.domain.favorites.GetAllFavoritesUseCase
import com.uvarov.coffeeshop.common.domain.product.GetAllProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase,
    private val getAllFavoritesUseCase: GetAllFavoritesUseCase,
) : ViewModel() {

    private val productsFlow = getAllProductsUseCase()
    private val favoritesFlow = getAllFavoritesUseCase()

    val state: StateFlow<FavoritesState> = combine(
        productsFlow, favoritesFlow
    ) { products, favorites ->
        val favoriteProducts = products.filter { it.id in favorites }
        FavoritesState.Success(favoriteProducts)
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        FavoritesState.Loading
    )
}