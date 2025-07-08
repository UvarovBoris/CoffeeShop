package com.example.coffeeshop.data

import androidx.annotation.DrawableRes

data class ProductData(
    val id: Int,
    val name: String,
    val description: String,
    @DrawableRes val image: Int,
    val price: String,
    val rating: Float
)