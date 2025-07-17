package com.uvarov.coffeeshop.common.domain.product

import kotlinx.coroutines.flow.Flow

interface GetAllProductsUseCase {
    operator fun invoke(): Flow<List<Product>>
}

class GetAllProductsUseCaseImpl(
    private val productRepository: ProductsRepository,
) : GetAllProductsUseCase {
    override operator fun invoke(): Flow<List<Product>> {
        return productRepository.getAllProducts()
    }
}