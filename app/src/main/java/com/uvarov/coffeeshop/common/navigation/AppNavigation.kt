package com.uvarov.coffeeshop.common.navigation

import kotlinx.serialization.Serializable

@Serializable
object Onboarding

@Serializable
object Main

@Serializable
data class ProductDetail(val productId: Int)

@Serializable
object Order