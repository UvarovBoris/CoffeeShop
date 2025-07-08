package com.example.coffeeshop.features.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.coffeeshop.R
import com.example.coffeeshop.data.ProductData

@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController(),
    onProductClick: (ProductData) -> Unit
) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomBar(
                items = bottomBarItems,
                currentRoute
            ) { bottomBarItemData ->
                navController.navigate(bottomBarItemData.route) {
                    popUpTo(navController.graph.startDestinationId) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }
    ) { padding ->
        MainNavHost(
            navController = navController,
            padding = padding,
            onProductClick = onProductClick
        )
    }
}

val bottomBarItems = listOf(
    BottomBarItemData(MainSubscreen.Home.route, R.drawable.home, R.drawable.home_filled),
    BottomBarItemData(MainSubscreen.Favorites.route, R.drawable.heart, R.drawable.heart_filled),
    BottomBarItemData(MainSubscreen.Purchases.route, R.drawable.bag, R.drawable.bag_filled),
    BottomBarItemData(MainSubscreen.Notifications.route, R.drawable.notification, R.drawable.notification_filled)
)

@Preview(
    widthDp = 360,
    heightDp = 800
)
@Composable
fun HomeScreenPreview() {
    MainScreen(
        rememberNavController(),
        onProductClick = {}
    )
}
