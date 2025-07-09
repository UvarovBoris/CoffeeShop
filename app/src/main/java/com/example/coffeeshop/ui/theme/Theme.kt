package com.example.coffeeshop.ui.theme

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoffeeShopTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        content = {
            CompositionLocalProvider(LocalRippleConfiguration provides GreyRipple) {
                content()
            }
        }
    )
}