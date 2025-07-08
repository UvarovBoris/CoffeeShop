package com.example.coffeeshop.features.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffeeshop.data.ProductData
import com.example.coffeeshop.data.allProducts
import com.example.coffeeshop.features.main.ProductItem
import com.example.coffeeshop.ui.theme.SurfaceLight

@Composable
fun FavoritesScreen(
    padding: PaddingValues,
    onProductClick: (ProductData) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = SurfaceLight)
            .padding(horizontal = 24.dp)
    ) {
        val products = allProducts
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                bottom = padding.calculateBottomPadding() + 24.dp
            ),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            items(products) { item ->
                ProductItem(
                    item,
                    onClick = onProductClick
                )
            }
        }
    }
}

@Preview(
    widthDp = 360,
    heightDp = 800
)
@Composable
fun FavoritesScreenPreview() {
    FavoritesScreen(
        padding = PaddingValues(0.dp),
        onProductClick = {}
    )
}