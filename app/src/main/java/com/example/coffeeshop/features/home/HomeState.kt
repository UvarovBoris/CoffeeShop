package com.example.coffeeshop.features.home

import com.example.coffeeshop.data.Category
import com.example.coffeeshop.domain.Product

data class HomeState(
    val category: Category = Category.AllCoffee,
    val productsState: ProductsState = ProductsState.Loading,
)

sealed class ProductsState {
    data object Loading : ProductsState()
    data class Success(
        val products: List<Product>,
    ) : ProductsState()
}