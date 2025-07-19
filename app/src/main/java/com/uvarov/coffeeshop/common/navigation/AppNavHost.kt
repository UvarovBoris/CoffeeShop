package com.uvarov.coffeeshop.common.navigation

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
import com.uvarov.coffeeshop.features.main.MainScreen
import com.uvarov.coffeeshop.features.onboarding.OnboardingScreen
import com.uvarov.coffeeshop.features.onboarding.OnboardingViewModel
import com.uvarov.coffeeshop.features.order.presentation.OrderScreen
import com.uvarov.coffeeshop.features.order.presentation.OrderViewModel
import com.uvarov.coffeeshop.features.productDetail.presentation.ProductDetailScreen
import com.uvarov.coffeeshop.features.productDetail.presentation.ProductDetailViewModel

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
                },
                onOrderClick = {
                    navController.navigate(Order)
                }
            )
        }
        composable<ProductDetail>(
            enterTransition = {
                slideInHorizontally(initialOffsetX = { fullWidth -> fullWidth })
            },
            exitTransition = {
                ExitTransition.None
            },
            popEnterTransition = {
                EnterTransition.None
            },
            popExitTransition = {
                slideOutHorizontally(targetOffsetX = { fullWidth -> fullWidth })
            }
        ) {
            val viewModel = hiltViewModel<ProductDetailViewModel>()
            ProductDetailScreen(
                viewModel,
                onBackClick = { navController.popBackStack() },
                onNavigation = { navController.navigate(it) }
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
            val viewModel = hiltViewModel<OrderViewModel>()
            OrderScreen(
                viewModel = viewModel,
                onBackClick = { navController.popBackStack() },
                onOrderClick = {}
            )
        }
    }
}