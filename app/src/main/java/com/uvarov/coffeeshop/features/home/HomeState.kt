package com.uvarov.coffeeshop.features.home

import com.uvarov.coffeeshop.common.data.product.ProductCategory
import com.uvarov.coffeeshop.common.domain.product.Product

data class HomeState(
    val searchText: String = "",
    val category: ProductCategory = ProductCategory.AllCoffee,
    val productsState: ProductsState = ProductsState.Loading,
)

sealed class ProductsState {
    data object Loading : ProductsState()
    data class Success(
        val products: List<Product>,
    ) : ProductsState()
}