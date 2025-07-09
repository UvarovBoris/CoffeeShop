package com.example.coffeeshop.domain

import kotlinx.coroutines.flow.Flow

interface GetAllProductsUseCase {
    fun execute(): Flow<List<Product>>
}

class GetAllProductsUseCaseImpl(
    private val productRepository: ProductsRepository,
) : GetAllProductsUseCase {
    override fun execute(): Flow<List<Product>> {
        return productRepository.getAllProducts()
    }
}