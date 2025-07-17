package com.uvarov.coffeeshop.domain

import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    fun getAllProducts(): Flow<List<Product>>

    fun getProduct(id: Int): Flow<Product>
}