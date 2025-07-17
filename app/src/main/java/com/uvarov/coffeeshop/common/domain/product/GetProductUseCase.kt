package com.uvarov.coffeeshop.common.domain.product

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