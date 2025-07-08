package com.example.coffeeshop.features.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.coffeeshop.data.ProductData
import com.example.coffeeshop.features.favorites.FavoritesScreen
import com.example.coffeeshop.features.home.HomeScreen
import com.example.coffeeshop.features.notifications.NotificationsScreen
import com.example.coffeeshop.features.purchases.PurchasesScreen

@Composable
fun MainNavHost(
    navController: NavHostController,
    padding: PaddingValues,
    onProductClick: (ProductData) -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = MainSubscreen.Home.route
    ) {
        composable(MainSubscreen.Home.route) {
            HomeScreen(
                padding,
                onProductClick = onProductClick
            )
        }
        composable(MainSubscreen.Favorites.route) {
            FavoritesScreen(
                padding,
                onProductClick = onProductClick
            )
        }
        composable(MainSubscreen.Purchases.route) {
            PurchasesScreen(padding)
        }
        composable(MainSubscreen.Notifications.route) {
            NotificationsScreen(padding)
        }
    }
}