package com.example.coffeeshop.navigation

import kotlinx.serialization.Serializable

@Serializable
object Onboarding

@Serializable
object Main

@Serializable
data class ProductDetails(val productId: Int)