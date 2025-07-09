package com.example.coffeeshop.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.coffeeshop.features.main.MainScreen
import com.example.coffeeshop.features.onboarding.OnboardingScreen
import com.example.coffeeshop.features.productDetails.ProductDetailsScreen

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Main
    ) {
        composable<Onboarding> {
            OnboardingScreen(
                onGetStartedClick = { navController.navigate(Main) }
            )
        }
        composable<Main>(
            enterTransition = {
                EnterTransition.None
            },
            exitTransition = {
                ExitTransition.None
            },
            popEnterTransition = {
                EnterTransition.None
            },
            popExitTransition = {
                ExitTransition.None
            }
        ) {
            MainScreen(
                onProductClick = { product ->
                    navController.navigate(ProductDetails(product.id))
                }
            )
        }
        composable<ProductDetails>(
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
            val productDetails = backStackEntry.toRoute<ProductDetails>()
            ProductDetailsScreen(productDetails.productId)
        }
    }
}