package com.example.coffeeshop.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coffeeshop.features.main.MainScreen
import com.example.coffeeshop.features.onboarding.OnboardingScreen
import com.example.coffeeshop.features.onboarding.OnboardingViewModel
import com.example.coffeeshop.features.order.OrderScreen
import com.example.coffeeshop.features.productDetail.ProductDetailScreen
import com.example.coffeeshop.features.productDetail.ProductDetailViewModel

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: Any,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable<Onboarding> {
            val viewModel = hiltViewModel<OnboardingViewModel>()
            OnboardingScreen(
                viewModel,
                onGetStartedClick = {
                    viewModel.onGetStartedClick()
                    navController.navigate(Main) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable<Main>(
            exitTransition = {
                ExitTransition.None
            },
            popEnterTransition = {
                EnterTransition.None
            }
        ) {
            MainScreen(
                onProductClick = { product ->
                    navController.navigate(ProductDetail(product.id))
                }
            )
        }
        composable<ProductDetail>(
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
        ) {
            val viewModel = hiltViewModel<ProductDetailViewModel>()
            ProductDetailScreen(
                viewModel,
                onBackClick = { navController.popBackStack() },
                onBuyClick = { navController.navigate(Order) }
            )
        }
        composable<Order>(
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
        ) {
            OrderScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}