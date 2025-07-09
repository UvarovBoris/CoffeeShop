package com.example.coffeeshop.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface ProductsDataSource {
    fun getAllProducts(): Flow<List<ProductEntity>>
}

class ProductsDataSourceImpl : ProductsDataSource {
    override fun getAllProducts(): Flow<List<ProductEntity>> {
        return flow {
            // Simulate a delay to mimic network or database call
            delay(1000)
            // Emit the list of products (this should be replaced with actual data fetching logic)
            emit(testProducts)
        }
    }
}