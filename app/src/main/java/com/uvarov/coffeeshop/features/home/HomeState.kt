package com.uvarov.coffeeshop.features.home

import com.uvarov.coffeeshop.data.Category
import com.uvarov.coffeeshop.domain.Product

data class HomeState(
    val searchText: String = "",
    val category: Category = Category.AllCoffee,
    val productsState: ProductsState = ProductsState.Loading,
)

sealed class ProductsState {
    data object Loading : ProductsState()
    data class Success(
        val products: List<Product>,
    ) : ProductsState()
}