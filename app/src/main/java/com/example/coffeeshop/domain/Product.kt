package com.example.coffeeshop.domain

import androidx.annotation.DrawableRes

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    @DrawableRes val image: Int,
    val price: String,
    val rating: Float
)