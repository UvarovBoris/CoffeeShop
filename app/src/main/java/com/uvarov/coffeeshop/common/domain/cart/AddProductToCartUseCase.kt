package com.uvarov.coffeeshop.common.domain.cart

interface AddProductToCartUseCase {
    suspend operator fun invoke(id: Int)
}

class AddProductToToCartUseCaseImpl(
    private val cartRepository: CartRepository,
) : AddProductToCartUseCase {

    override suspend operator fun invoke(id: Int) {
        return cartRepository.addProduct(id)
    }
}