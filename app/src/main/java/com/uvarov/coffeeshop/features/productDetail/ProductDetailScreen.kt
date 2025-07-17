package com.uvarov.coffeeshop.features.productDetail

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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.uvarov.coffeeshop.R
import com.uvarov.coffeeshop.common.presentation.TopBar
import com.uvarov.coffeeshop.common.presentation.TopBarButton
import com.uvarov.coffeeshop.common.presentation.utils.SetStatusBarTextColor
import com.uvarov.coffeeshop.data.testProducts
import com.uvarov.coffeeshop.data.toDomain
import com.uvarov.coffeeshop.domain.ProductVariant
import com.uvarov.coffeeshop.ui.theme.SurfaceLight
import com.uvarov.coffeeshop.ui.theme.SurfaceLightActive

@Composable
fun ProductDetailScreen(
    viewModel: ProductDetailViewModel,
    onBackClick: () -> Unit,
    onBuyClick: () -> Unit,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    ProductDetailScreen(
        state,
        onBackClick,
        onVariantSelect = viewModel::onVariantSelect,
        onBuyClick
    )
}

@Composable
fun ProductDetailScreen(
    state: ProductDetailState,
    onBackClick: () -> Unit,
    onVariantSelect: (ProductVariant) -> Unit,
    onBuyClick: () -> Unit,
) {
    SetStatusBarTextColor(isDark = true)
    val product = if (state is ProductDetailState.Success) state.product else null
    val selectedVariant = if (state is ProductDetailState.Success) state.selectedVariant else null
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(
                title = stringResource(R.string.product_detail_title),
                rightButton = {
                    TopBarButton(
                        icon = R.drawable.heart,
                        contentDescription = "Favorites",
                        onClick = { }
                    )
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
                HorizontalDivider(
                    thickness = 1.dp,
                    color = SurfaceLightActive,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                )
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

@Preview
@Composable
fun ProductDetailScreenPreview() {
    val product = testProducts.first().toDomain()
    ProductDetailScreen(
        state = ProductDetailState.Success(product, product.variants.first()),
        onBackClick = {},
        onVariantSelect = {},
        onBuyClick = {}
    )
}