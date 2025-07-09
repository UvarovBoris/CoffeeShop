package com.example.coffeeshop.features.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.coffeeshop.data.ProductData
import com.example.coffeeshop.features.favorites.FavoritesScreen
import com.example.coffeeshop.features.home.HomeScreen
import com.example.coffeeshop.features.home.HomeViewModel
import com.example.coffeeshop.features.notifications.NotificationsScreen
import com.example.coffeeshop.features.purchases.PurchasesScreen

@Composable
fun MainNavHost(
    navController: NavHostController,
    padding: PaddingValues,
    onProductClick: (ProductData) -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = Home
    ) {
        composable<Home> {
            val viewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(
                viewModel,
                padding,
                onProductClick = onProductClick
            )
        }
        composable<Favorites> {
            FavoritesScreen(
                padding,
                onProductClick = onProductClick
            )
        }
        composable<Purchases> {
            PurchasesScreen(padding)
        }
        composable<Notifications> {
            NotificationsScreen(padding)
        }
    }
}