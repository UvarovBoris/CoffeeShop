package com.example.coffeeshop.data

import com.example.coffeeshop.domain.Product
import com.example.coffeeshop.domain.ProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProductsRepositoryImpl(
    private val productsDataSource: ProductsDataSource,
) : ProductsRepository {

    override fun getAllProducts(): Flow<List<Product>> {
        return productsDataSource.getAllProducts()
            .map { entities -> entities.map { it.toDomain() } }
    }
}