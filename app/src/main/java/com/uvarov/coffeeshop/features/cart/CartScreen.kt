package com.uvarov.coffeeshop.features.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvarov.coffeeshop.common.presentation.utils.SetStatusBarTextColor
import com.uvarov.coffeeshop.ui.theme.SurfaceLight

@Composable
fun CartScreen(
    padding: PaddingValues,
    onOrderClick: () -> Unit,
) {
    SetStatusBarTextColor(isDark = true)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = SurfaceLight)
            .padding(
                start = 24.dp,
                end = 24.dp,
                top = padding.calculateTopPadding()
            )
    ) {
        Button(onClick = onOrderClick) {
            Text(text = "Order")
        }
    }
}

@Preview(
    widthDp = 360,
    heightDp = 800
)
@Composable
fun PurchasesScreenPreview() {
    CartScreen(
        padding = PaddingValues(0.dp),
        onOrderClick = {}
    )
}