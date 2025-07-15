package com.example.coffeeshop.domain

import androidx.annotation.DrawableRes
import com.example.coffeeshop.data.Category

data class Product(
    val id: Int,
    val name: String,
    val category: Category,
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