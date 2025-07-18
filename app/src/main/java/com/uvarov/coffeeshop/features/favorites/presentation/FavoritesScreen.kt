package com.uvarov.coffeeshop.features.favorites.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.uvarov.coffeeshop.common.data.testProducts
import com.uvarov.coffeeshop.common.data.product.toDomain
import com.uvarov.coffeeshop.common.domain.product.Product
import com.uvarov.coffeeshop.common.presentation.product.ProductItem
import com.uvarov.coffeeshop.common.presentation.utils.SetStatusBarTextColor
import com.uvarov.coffeeshop.common.presentation.theme.SurfaceLight

@Composable
fun FavoritesScreen(
    viewModel: FavoritesViewModel,
    padding: PaddingValues,
    onProductClick: (Product) -> Unit,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
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
    onProductClick: (Product) -> Unit,
) {
    SetStatusBarTextColor(isDark = true)
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .background(color = SurfaceLight)
            .padding(top = padding.calculateTopPadding()),
        contentPadding = PaddingValues(
            top = 24.dp,
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
        state = FavoritesState.Success(testProducts.map { it.toDomain() }),
        padding = PaddingValues(0.dp),
        onProductClick = {}
    )
}