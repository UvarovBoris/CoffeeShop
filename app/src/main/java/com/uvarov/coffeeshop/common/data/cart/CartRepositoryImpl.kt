package com.uvarov.coffeeshop.common.data.cart

import com.uvarov.coffeeshop.common.domain.cart.CartRepository
import kotlinx.coroutines.flow.Flow

class CartRepositoryImpl(
    private val cartDataSource: CartDataSource,
) : CartRepository {

    override fun getAllProducts(): Flow<Map<Int, Int>> {
        return cartDataSource.getAllProducts()
    }

    override suspend fun addProduct(id: Int) {
        cartDataSource.addProduct(id)
    }

    override suspend fun removeProduct(id: Int) {
        cartDataSource.removeProduct(id)
    }
}