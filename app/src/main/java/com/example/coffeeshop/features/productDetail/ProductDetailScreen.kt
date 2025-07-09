package com.example.coffeeshop.features.productDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.coffeeshop.data.ProductData
import com.example.coffeeshop.data.allProducts
import com.example.coffeeshop.ui.SetStatusBarTextColor
import com.example.coffeeshop.ui.theme.SurfaceLight

@Composable
fun ProductDetailScreen(
    product: ProductData,
    onBackClick: () -> Unit,
) {
    SetStatusBarTextColor(isDark = true)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBar(onBackClick = onBackClick) },
        bottomBar = { BuySection(product) }
    ) { padding ->
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
        }
    }
}

@Preview
@Composable
fun ProductDetailScreenPreview() {
    ProductDetailScreen(allProducts.first(), {})
}