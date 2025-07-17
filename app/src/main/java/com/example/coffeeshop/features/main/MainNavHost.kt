package com.example.coffeeshop.features.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.coffeeshop.domain.Product
import com.example.coffeeshop.features.cart.CartScreen
import com.example.coffeeshop.features.favorites.FavoritesScreen
import com.example.coffeeshop.features.favorites.FavoritesViewModel
import com.example.coffeeshop.features.home.HomeScreen
import com.example.coffeeshop.features.home.HomeViewModel
import com.example.coffeeshop.features.profile.ProfileScreen

@Composable
fun MainNavHost(
    navController: NavHostController,
    padding: PaddingValues,
    onProductClick: (Product) -> Unit,
    onOrderClick: () -> Unit,
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
            val viewModel = hiltViewModel<FavoritesViewModel>()
            FavoritesScreen(
                viewModel,
                padding,
                onProductClick = onProductClick
            )
        }
        composable<Cart> {
            CartScreen(
                padding,
                onOrderClick = onOrderClick
            )
        }
        composable<Profile> {
            ProfileScreen(padding)
        }
    }
}