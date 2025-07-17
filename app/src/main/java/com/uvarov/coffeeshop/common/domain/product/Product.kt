package com.uvarov.coffeeshop.common.domain.product

import androidx.annotation.DrawableRes
import com.uvarov.coffeeshop.common.data.product.ProductCategory

data class Product(
    val id: Int,
    val name: String,
    val category: ProductCategory,
    @DrawableRes val image: Int,
    val variants: List<ProductVariant>,
    val rating: Float,
    val description: String,
)

data class ProductVariant(
    val id: Int,
    val size: ProductSize,
    val price: Float,
)

enum class ProductSize {
    Small,
    Medium,
    Large
}