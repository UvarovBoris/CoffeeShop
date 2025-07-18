package com.uvarov.coffeeshop.common.data.cart

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

interface CartDataSource {
    fun getAllProducts(): Flow<Map<Int, Int>>

    suspend fun addProduct(id: Int)

    suspend fun removeProduct(id: Int)
}

class CartDataSourceImpl : CartDataSource {

    private val products: MutableStateFlow<Map<Int, Int>> = MutableStateFlow(emptyMap())

    override fun getAllProducts(): Flow<Map<Int, Int>> {
        return products
    }

    override suspend fun addProduct(id: Int) {
        products.update { currentMap ->
            currentMap.toMutableMap().apply {
                this[id] = this.getOrDefault(id, 0) + 1
            }
        }
    }

    override suspend fun removeProduct(id: Int) {
        products.update { currentMap ->
            currentMap.toMutableMap().apply {
                if (containsKey(id)) {
                    val newCount = this[id]!! - 1
                    if (newCount <= 0) {
                        remove(id)
                    } else {
                        this[id] = newCount
                    }
                }
            }
        }
    }
}