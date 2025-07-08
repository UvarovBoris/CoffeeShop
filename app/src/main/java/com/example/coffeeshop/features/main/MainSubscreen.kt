package com.example.coffeeshop.features.main

sealed class MainSubscreen(val route: String) {
    object Home : MainSubscreen("home")
    object Favorites : MainSubscreen("favorites")
    object Purchases : MainSubscreen("purchases")
    object Notifications : MainSubscreen("notifications")
}