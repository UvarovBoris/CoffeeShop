package com.example.coffeeshop.data

import com.example.coffeeshop.domain.Product
import com.example.coffeeshop.domain.ProductsRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProductsRepositoryImpl : ProductsRepository {
    override fun getAllProducts(): Flow<List<Product>> {
        return flow {
            // Simulate a delay to mimic network or database call
            delay(1000)
            // Emit the list of products (this should be replaced with actual data fetching logic)
            emit(testProducts.map { it.toDomain() })
        }
    }
}