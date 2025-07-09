package com.example.coffeeshop.features.productDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffeeshop.ui.SetStatusBarTextColor
import com.example.coffeeshop.ui.theme.SurfaceLight

@Composable
fun ProductDetailsScreen(productId: Int) {
    SetStatusBarTextColor(isDark = true)
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = SurfaceLight),
            contentAlignment = Alignment.Center
        ) {
            Text("ProductDetails")
        }
    }
}

@Preview
@Composable
fun ProductDetailsScreenPreview() {
    ProductDetailsScreen(productId = 0)
}