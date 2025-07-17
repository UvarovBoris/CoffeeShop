package com.uvarov.coffeeshop.common.domain.product

import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    fun getAllProducts(): Flow<List<Product>>

    fun getProduct(id: Int): Flow<Product>
}