package com.uvarov.coffeeshop.common.data.product

import com.uvarov.coffeeshop.common.domain.product.Product
import com.uvarov.coffeeshop.common.domain.product.ProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProductsRepositoryImpl(
    private val productsDataSource: ProductsDataSource,
) : ProductsRepository {

    override fun getAllProducts(): Flow<List<Product>> {
        return productsDataSource.getAllProducts()
            .map { entities -> entities.map { it.toDomain() } }
    }

    override fun getProduct(id: Int): Flow<Product> {
        return productsDataSource.getProduct(id)
            .map { it.toDomain() }
    }
}