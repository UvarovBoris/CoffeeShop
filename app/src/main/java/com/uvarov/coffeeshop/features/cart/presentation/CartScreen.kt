package com.uvarov.coffeeshop.features.cart.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.uvarov.coffeeshop.R
import com.uvarov.coffeeshop.common.data.product.toDomain
import com.uvarov.coffeeshop.common.data.testProducts
import com.uvarov.coffeeshop.common.domain.product.Product
import com.uvarov.coffeeshop.common.presentation.cart.CartItem
import com.uvarov.coffeeshop.common.presentation.theme.CoffeeColor
import com.uvarov.coffeeshop.common.presentation.theme.SurfaceLight
import com.uvarov.coffeeshop.common.presentation.utils.SetStatusBarTextColor

@Composable
fun CartScreen(
    viewModel: CartViewModel,
    padding: PaddingValues,
    onOrderClick: () -> Unit = {},
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    CartScreen(
        state = state,
        padding = padding,
        onOrderClick = onOrderClick,
        onAddToCartClick = viewModel::onAddToCartClick,
        onRemoveFromCartClick = viewModel::onRemoveFromCartClick
    )
}

@Composable
fun CartScreen(
    state: CartState,
    padding: PaddingValues,
    onAddToCartClick: (Product) -> Unit = {},
    onRemoveFromCartClick: (Product) -> Unit = {},
    onOrderClick: () -> Unit = {},
) {
    SetStatusBarTextColor(isDark = true)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = SurfaceLight)
            .padding(
                top = padding.calculateTopPadding()
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = SurfaceLight)
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                )
        ) {
            val products = if (state is CartState.Success) state.products else emptyMap()
            products.forEach { (product, quantity) ->
                CartItem(
                    product,
                    quantity,
                    onPlusClick = onAddToCartClick,
                    onMinusClick = onRemoveFromCartClick
                )
                Spacer(Modifier.height(16.dp))
            }
        }
        FloatingActionButton(
            containerColor = CoffeeColor.actionButton,
            contentColor = CoffeeColor.onActionButton,
            onClick = onOrderClick,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(
                    end = 16.dp,
                    bottom = 16.dp + padding.calculateBottomPadding()
                )
        ) {
            Icon(
                painterResource(R.drawable.wallet),
                contentDescription = "Order",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview(
    widthDp = 360,
    heightDp = 800
)
@Composable
fun PurchasesScreenPreview() {
    val products = mapOf(testProducts.first().toDomain() to 1)
    CartScreen(
        state = CartState.Success(products),
        padding = PaddingValues(0.dp)
    )
}