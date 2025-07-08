package com.example.coffeeshop.features.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.coffeeshop.R
import com.example.coffeeshop.data.ProductData

@Composable
fun MainScreen(
    navController: NavHostController,
    onBottomNavigationClick: (String) -> Unit = {},
    onProductClick: (ProductData) -> Unit
) {
    var selectedItem by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomBar(
                items = bottomBarItems,
                selectedItem
            ) { bottomBarData ->
                selectedItem = bottomBarData.id
                onBottomNavigationClick(bottomBarData.screen.route)
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
    BottomBarItemData(0, MainSubscreen.Home, R.drawable.home, R.drawable.home_filled),
    BottomBarItemData(1, MainSubscreen.Favorites, R.drawable.heart, R.drawable.heart_filled),
    BottomBarItemData(2, MainSubscreen.Purchases, R.drawable.bag, R.drawable.bag_filled),
    BottomBarItemData(3, MainSubscreen.Notifications, R.drawable.notification, R.drawable.notification_filled)
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
