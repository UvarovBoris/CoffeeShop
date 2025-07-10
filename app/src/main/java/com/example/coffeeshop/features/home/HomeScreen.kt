package com.example.coffeeshop.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.coffeeshop.data.testProducts
import com.example.coffeeshop.data.testCategories
import com.example.coffeeshop.data.toDomain
import com.example.coffeeshop.domain.Product
import com.example.coffeeshop.features.main.CategoriesSection
import com.example.coffeeshop.features.main.ProductItem
import com.example.coffeeshop.features.main.TopSection
import com.example.coffeeshop.ui.SetStatusBarTextColor
import com.example.coffeeshop.ui.theme.SurfaceLight

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    padding: PaddingValues,
    onProductClick: (Product) -> Unit,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    HomeScreen(
        state,
        padding,
        onProductClick
    )
}

@Composable
fun HomeScreen(
    state: HomeState,
    padding: PaddingValues,
    onProductClick: (Product) -> Unit,
) {
    SetStatusBarTextColor(isDark = false)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = SurfaceLight)
    ) {
        var selectedCategory by remember { mutableStateOf(testCategories.first()) }

        TopSection(
            paddingTop = padding.calculateTopPadding(),
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        CategoriesSection(
            categories = testCategories,
            selectedCategory = selectedCategory,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 24.dp,
                    end = 24.dp
                ),
        ) {
            selectedCategory = it
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                start = 24.dp,
                end = 24.dp,
                bottom = padding.calculateBottomPadding()
            ),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (state is HomeState.Success) {
                items(
                    state.products,
                    key = { it.id }
                ) { item ->
                    ProductItem(
                        item,
                        modifier = Modifier.padding(bottom = 24.dp),
                        onClick = onProductClick
                    )
                }
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
        state = HomeState.Success(testProducts.map { it.toDomain() }),
        padding = PaddingValues(0.dp),
        onProductClick = {}
    )
}