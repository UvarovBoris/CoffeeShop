package com.uvarov.coffeeshop.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uvarov.coffeeshop.common.data.product.ProductCategory
import com.uvarov.coffeeshop.common.domain.product.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
) : ViewModel() {

    private val searchText = MutableStateFlow("")
    private val selectedCategory = MutableStateFlow(ProductCategory.AllCoffee)
    private val products = getProductsUseCase()

    val state: StateFlow<HomeState> = combine(
        searchText, selectedCategory, products
    ) { searchText, selectedCategory, allProducts ->
        val filteredProducts = allProducts
            .filter { searchText.isBlank() || it.name.contains(searchText, ignoreCase = true) }
            .filter { selectedCategory == ProductCategory.AllCoffee || it.category == selectedCategory }
        HomeState(
            searchText = searchText,
            category = selectedCategory,
            productsState = ProductsState.Success(filteredProducts)
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        HomeState()
    )

    fun onCategorySelect(category: ProductCategory) {
        selectedCategory.value = category
    }

    fun onSearchTextChange(text: String) {
        searchText.value = text
    }
}