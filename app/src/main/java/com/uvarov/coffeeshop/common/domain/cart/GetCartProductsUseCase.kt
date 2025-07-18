package com.uvarov.coffeeshop.common.domain.cart

import kotlinx.coroutines.flow.Flow

interface GetCartProductsUseCase {
    operator fun invoke(): Flow<Map<Int, Int>>
}

class GetCartProductsUseCaseImpl(
    private val cartRepository: CartRepository,
) : GetCartProductsUseCase {

    override operator fun invoke(): Flow<Map<Int, Int>> {
        return cartRepository.getAllProducts()
    }
}