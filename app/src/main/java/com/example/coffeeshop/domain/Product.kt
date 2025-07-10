package com.example.coffeeshop.domain

import androidx.annotation.DrawableRes
import com.example.coffeeshop.data.Category

data class Product(
    val id: Int,
    val name: String,
    val category: Category,
    @DrawableRes val image: Int,
    val price: String,
    val rating: Float,
)