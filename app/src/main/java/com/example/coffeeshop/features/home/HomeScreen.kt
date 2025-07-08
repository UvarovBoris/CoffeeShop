package com.example.coffeeshop.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffeeshop.data.ProductData
import com.example.coffeeshop.data.allProducts
import com.example.coffeeshop.data.categories
import com.example.coffeeshop.features.main.CategoriesSection
import com.example.coffeeshop.features.main.ProductItem
import com.example.coffeeshop.ui.theme.SurfaceLight

@Composable
fun HomeScreen(
    padding: PaddingValues,
    onProductClick: (ProductData) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = SurfaceLight)
            .padding(horizontal = 24.dp)
    ) {
        var selectedCategory by remember { mutableStateOf(categories.first()) }
        val products = allProducts
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                bottom = padding.calculateBottomPadding()
            ),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item(span = { GridItemSpan(2) }) {
                CategoriesSection(
                    categories = categories,
                    selectedCategory = selectedCategory,
                    modifier = Modifier.padding(
                        top = 24.dp,
                        bottom = 16.dp
                    ),
                ) {
                    selectedCategory = it
                }
            }
            items(products) { item ->
                ProductItem(
                    item,
                    modifier = Modifier.padding(bottom = 24.dp),
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
fun HomeScreenPreview() {
    HomeScreen(
        padding = PaddingValues(0.dp),
        onProductClick = {}
    )
}