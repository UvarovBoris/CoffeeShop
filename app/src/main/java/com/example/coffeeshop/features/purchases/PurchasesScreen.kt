package com.example.coffeeshop.features.purchases

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffeeshop.common.presentation.utils.SetStatusBarTextColor
import com.example.coffeeshop.ui.theme.SurfaceLight

@Composable
fun PurchasesScreen(
    padding: PaddingValues
) {
    SetStatusBarTextColor(isDark = true)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = SurfaceLight)
            .padding(horizontal = 24.dp)
    ) {
        Text(text = "Purchases")
    }
}

@Preview(
    widthDp = 360,
    heightDp = 800
)
@Composable
fun PurchasesScreenPreview() {
    PurchasesScreen(
        padding = PaddingValues(0.dp)
    )
}