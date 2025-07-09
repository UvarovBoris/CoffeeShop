package com.example.coffeeshop.features.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.coffeeshop.data.ProductData
import com.example.coffeeshop.data.allProducts
import com.example.coffeeshop.features.main.ProductItem
import com.example.coffeeshop.ui.SetStatusBarTextColor
import com.example.coffeeshop.ui.theme.SurfaceLight

@Composable
fun FavoritesScreen(
    viewModel: FavoritesViewModel,
    padding: PaddingValues,
    onProductClick: (ProductData) -> Unit,
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    FavoritesScreen(
        state,
        padding,
        onProductClick
    )
}

@Composable
fun FavoritesScreen(
    state: FavoritesState,
    padding: PaddingValues,
    onProductClick: (ProductData) -> Unit,
) {
    SetStatusBarTextColor(isDark = true)
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .background(color = SurfaceLight),
        contentPadding = PaddingValues(
            top = padding.calculateTopPadding(),
            bottom = padding.calculateBottomPadding() + 24.dp,
            start = 24.dp,
            end = 24.dp
        ),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        if (state is FavoritesState.Success) {
            items(
                state.products,
                key = { it.id }
            ) { item ->
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
    heightDp = 800,
    backgroundColor = 0xFF000000,
    showBackground = true
)
@Composable
fun FavoritesScreenPreview() {
    FavoritesScreen(
        state = FavoritesState.Success(allProducts),
        padding = PaddingValues(0.dp),
        onProductClick = {}
    )
}