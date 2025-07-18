package com.uvarov.coffeeshop.common.domain.cart

interface RemoveProductFromCartUseCase {
    suspend operator fun invoke(id: Int)
}

class RemoveProductFromFromCartUseCaseImpl(
    private val cartRepository: CartRepository,
) : RemoveProductFromCartUseCase {

    override suspend operator fun invoke(id: Int) {
        return cartRepository.removeProduct(id)
    }
}