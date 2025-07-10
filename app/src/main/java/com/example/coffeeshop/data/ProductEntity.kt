package com.example.coffeeshop.data

import androidx.annotation.DrawableRes
import com.example.coffeeshop.domain.Product

data class ProductEntity(
    val id: Int,
    val name: String,
    val category: Category,
    @DrawableRes val image: Int,
    val price: String,
    val rating: Float,
)

fun ProductEntity.toDomain(): Product {
    return Product(
        id = id,
        name = name,
        category = category,
        image = image,
        price = price,
        rating = rating
    )
}