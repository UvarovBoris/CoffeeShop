package com.uvarov.coffeeshop.common.domain.product

import kotlinx.coroutines.flow.Flow

interface GetProductsUseCase {
    operator fun invoke(): Flow<List<Product>>
}

class GetProductsUseCaseImpl(
    private val productRepository: ProductsRepository,
) : GetProductsUseCase {
    override operator fun invoke(): Flow<List<Product>> {
        return productRepository.getAllProducts()
    }
}