package com.uvarov.coffeeshop.common.presentation.theme

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun CoffeeShopTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        content = {
            @OptIn(ExperimentalMaterial3Api::class)
            CompositionLocalProvider(LocalRippleConfiguration provides RippleGrey) {
                content()
            }
        }
    )
}