package com.example.coffeeshop.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface ProductsDataSource {
    fun getAllProducts(): Flow<List<ProductEntity>>

    fun getProduct(id: Int): Flow<ProductEntity>
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

    override fun getProduct(id: Int): Flow<ProductEntity> {
        return flow {
            // Simulate a delay to mimic network or database call
            delay(500)
            // Find the product by id and emit it (this should be replaced with actual data fetching logic)
            val product = testProducts.find { it.id == id }
            if (product != null) {
                emit(product)
            } else {
                throw NoSuchElementException("Product with id $id not found")
            }
        }
    }
}