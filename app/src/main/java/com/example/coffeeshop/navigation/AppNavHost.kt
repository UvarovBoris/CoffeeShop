package com.example.coffeeshop.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.coffeeshop.features.home.HomeScreen
import com.example.coffeeshop.features.onboarding.OnboardingScreen
import com.example.coffeeshop.features.productDetails.ProductDetailsScreen

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Onboarding.route) {
            OnboardingScreen(
                onGetStartedClick = { navController.navigate(Screen.Home.route) }
            )
        }
        composable(
            Screen.Home.route,
            enterTransition = {
                slideInHorizontally(initialOffsetX = { fullWidth -> 0 })
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = { fullWidth -> 0 })
            },
            popEnterTransition = {
                slideInHorizontally(initialOffsetX = { fullWidth -> 0 })
            },
            popExitTransition = {
                slideOutHorizontally(targetOffsetX = { fullWidth -> 0 })
            }
        ) {
            HomeScreen(
                onProductClick = { product ->
                    navController.navigate(Screen.ProductDetails.createRoute(product.id))
                }
            )
        }
        composable(
            route = Screen.ProductDetails.route,
            arguments = listOf(navArgument("productId") { type = NavType.IntType }),
            enterTransition = {
                slideInHorizontally(initialOffsetX = { fullWidth -> fullWidth })
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = { fullWidth -> -fullWidth })
            },
            popEnterTransition = {
                slideInHorizontally(initialOffsetX = { fullWidth -> -fullWidth })
            },
            popExitTransition = {
                slideOutHorizontally(targetOffsetX = { fullWidth -> fullWidth })
            }
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId") ?: -1
            ProductDetailsScreen(productId)
        }
    }
}