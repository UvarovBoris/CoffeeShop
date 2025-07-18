package com.uvarov.coffeeshop.common.domain.cart

import kotlinx.coroutines.flow.Flow

interface CartRepository {

    fun getAllProducts(): Flow<Map<Int, Int>>

    suspend fun addProduct(id: Int)

    suspend fun removeProduct(id: Int)
}