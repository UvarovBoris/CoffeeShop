package com.uvarov.coffeeshop.features.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.uvarov.coffeeshop.domain.Product
import com.uvarov.coffeeshop.features.cart.CartScreen
import com.uvarov.coffeeshop.features.favorites.FavoritesScreen
import com.uvarov.coffeeshop.features.favorites.FavoritesViewModel
import com.uvarov.coffeeshop.features.home.HomeScreen
import com.uvarov.coffeeshop.features.home.HomeViewModel
import com.uvarov.coffeeshop.features.profile.ProfileScreen

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