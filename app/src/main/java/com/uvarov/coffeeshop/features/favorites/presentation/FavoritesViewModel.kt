package com.uvarov.coffeeshop.features.favorites.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uvarov.coffeeshop.common.domain.favorites.GetFavoritesUseCase
import com.uvarov.coffeeshop.common.domain.product.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val getFavoritesUseCase: GetFavoritesUseCase,
) : ViewModel() {

    private val productsFlow = getProductsUseCase()
    private val favoritesFlow = getFavoritesUseCase()

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