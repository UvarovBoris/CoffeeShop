package com.uvarov.coffeeshop.features.productDetail.presentation

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import coil.compose.AsyncImage
import com.uvarov.coffeeshop.R
import com.uvarov.coffeeshop.common.data.product.toDomain
import com.uvarov.coffeeshop.common.data.testProducts
import com.uvarov.coffeeshop.common.domain.product.ProductVariant
import com.uvarov.coffeeshop.common.presentation.SectionDivider
import com.uvarov.coffeeshop.common.presentation.TopBar
import com.uvarov.coffeeshop.common.presentation.TopBarButton
import com.uvarov.coffeeshop.common.presentation.theme.Brown
import com.uvarov.coffeeshop.common.presentation.theme.CoffeeTheme
import com.uvarov.coffeeshop.common.presentation.theme.SurfaceLight
import com.uvarov.coffeeshop.common.presentation.utils.SetStatusBarTextColor

@Composable
fun ProductDetailScreen(
    viewModel: ProductDetailViewModel,
    onBackClick: () -> Unit = {},
    onNavigation: (Any) -> Unit = {},
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(Unit) {
        viewModel.navigationEvent
            .flowWithLifecycle(lifecycleOwner.lifecycle)
            .collect { route ->
                onNavigation(route)
            }
    }

    val state by viewModel.state.collectAsStateWithLifecycle()
    ProductDetailScreen(
        state,
        onBackClick,
        onFavoritesClick = viewModel::onFavoriteToggle,
        onVariantSelect = viewModel::onVariantSelect,
        onBuyClick = viewModel::onBuyClick
    )
}

@Composable
fun ProductDetailScreen(
    state: ProductDetailState,
    onBackClick: () -> Unit = {},
    onFavoritesClick: () -> Unit = {},
    onVariantSelect: (ProductVariant) -> Unit = {},
    onBuyClick: () -> Unit = {},
) {
    SetStatusBarTextColor(isDark = true)
    val product = if (state is ProductDetailState.Success) state.product else null
    val selectedVariant = if (state is ProductDetailState.Success) state.selectedVariant else null
    val isFavorite = if (state is ProductDetailState.Success) state.isFavorite else false
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(
                title = stringResource(R.string.product_detail_title),
                rightButton = {
                    FavoritesButton(isFavorite, onFavoritesClick)
                },
                needBack = true,
                onBackClick = onBackClick
            )
        },
        bottomBar = {
            selectedVariant?.let {
                BuySection(
                    variant = selectedVariant,
                    onBuyClick = onBuyClick
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = rememberScrollState())
                .background(color = SurfaceLight)
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = padding.calculateTopPadding(),
                    bottom = padding.calculateBottomPadding()
                )
        ) {
            if (product != null && selectedVariant != null) {
                Spacer(Modifier.height(24.dp))
                AsyncImage(
                    model = product.image,
                    contentDescription = "Product image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(327f / 202f)
                        .clip(RoundedCornerShape(16.dp))
                )
                Spacer(Modifier.height(16.dp))
                DetailSection(product = product)
                Spacer(Modifier.height(16.dp))
                SectionDivider()
                Spacer(Modifier.height(16.dp))
                DescriptionSection(product)
                Spacer(modifier = Modifier.height(24.dp))
                SizeSection(
                    product.variants,
                    selectedVariant,
                    onItemSelect = onVariantSelect
                )
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
private fun FavoritesButton(isFavorite: Boolean, onFavoritesClick: () -> Unit) {
    TopBarButton(
        onClick = onFavoritesClick
    ) {
        Crossfade(isFavorite) {
            if (it) {
                Icon(
                    painter = painterResource(R.drawable.heart_filled),
                    contentDescription = "Remove from favorites",
                    tint = Brown,
                )
            } else {
                Icon(
                    painter = painterResource(R.drawable.heart),
                    contentDescription = "Add to favorites",
                    tint = CoffeeTheme.color.onTopBar,
                )
            }
        }
    }
}

@Preview
@Composable
fun ProductDetailScreenPreview() {
    val product = testProducts.first().toDomain()
    val state = ProductDetailState.Success(
        product,
        true,
        product.variants.first()
    )
    ProductDetailScreen(state = state)
}