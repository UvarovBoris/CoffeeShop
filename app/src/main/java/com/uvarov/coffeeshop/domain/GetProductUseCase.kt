package com.uvarov.coffeeshop.domain

import kotlinx.coroutines.flow.Flow

interface GetProductUseCase {
    operator fun invoke(id: Int): Flow<Product>
}

class GetProductUseCaseImpl(
    private val productRepository: ProductsRepository,
) : GetProductUseCase {
    override operator fun invoke(id: Int): Flow<Product> {
        return productRepository.getProduct(id)
    }
}