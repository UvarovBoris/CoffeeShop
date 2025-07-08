package com.example.coffeeshop.navigation

sealed class Screen(val route: String) {
    object Onboarding : Screen("onboarding")
    object Main : Screen("main")
    object ProductDetails : Screen("productDetails/{productId}") {
        fun createRoute(productId: Int) = "productDetails/$productId"
    }
}