package com.uvarov.coffeeshop.features.home

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.uvarov.coffeeshop.common.data.product.ProductCategory
import com.uvarov.coffeeshop.common.data.product.toDomain
import com.uvarov.coffeeshop.common.data.testCategories
import com.uvarov.coffeeshop.common.data.testProducts
import com.uvarov.coffeeshop.common.domain.product.Product
import com.uvarov.coffeeshop.common.presentation.product.ProductItem
import com.uvarov.coffeeshop.common.presentation.theme.SurfaceLight
import com.uvarov.coffeeshop.common.presentation.utils.SetStatusBarTextColor

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    padding: PaddingValues,
    onProductClick: (Product) -> Unit,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    HomeScreen(
        state = state,
        padding = padding,
        onProductClick = onProductClick,
        onAddToCartClick = viewModel::onAddToCartClick,
        onSearchTextChange = viewModel::onSearchTextChange,
        onCategorySelect = viewModel::onCategorySelect
    )
}

@Composable
fun HomeScreen(
    state: HomeState,
    padding: PaddingValues,
    onProductClick: (Product) -> Unit = {},
    onAddToCartClick: (Product) -> Unit = {},
    onSearchTextChange: (String) -> Unit = {},
    onCategorySelect: (ProductCategory) -> Unit = {},
) {
    SetStatusBarTextColor(isDark = false)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = SurfaceLight)
    ) {
        TopSection(
            modifier = Modifier
                .fillMaxWidth(),
            paddingTop = padding.calculateTopPadding(),
            searchText = state.searchText,
            onSearchTextChange = onSearchTextChange
        )
        Spacer(modifier = Modifier.height(24.dp))
        CategoriesSection(
            categories = testCategories,
            selectedCategory = state.category,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 24.dp,
                    end = 24.dp
                ),
            onCategorySelected = onCategorySelect
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .clipToBounds(),
            contentPadding = PaddingValues(
                start = 24.dp,
                end = 24.dp,
                bottom = padding.calculateBottomPadding() + 24.dp
            ),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            if (state.productsState is ProductsState.Success) {
                items(
                    state.productsState.products,
                    key = { it.id }
                ) { item ->
                    ProductItem(
                        item,
                        modifier = Modifier.animateItem(),
                        onClick = onProductClick,
                        onAddToCartClick = onAddToCartClick
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
        state = HomeState(
            productsState = ProductsState.Success(testProducts.map { it.toDomain() })
        ),
        padding = PaddingValues(0.dp),
    )
}