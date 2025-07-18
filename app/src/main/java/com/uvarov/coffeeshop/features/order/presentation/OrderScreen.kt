package com.uvarov.coffeeshop.features.order.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.uvarov.coffeeshop.R
import com.uvarov.coffeeshop.common.data.product.toDomain
import com.uvarov.coffeeshop.common.data.testProducts
import com.uvarov.coffeeshop.common.presentation.SectionDivider
import com.uvarov.coffeeshop.common.presentation.TopBar
import com.uvarov.coffeeshop.common.presentation.cart.CartItem
import com.uvarov.coffeeshop.common.presentation.theme.SurfaceLight
import com.uvarov.coffeeshop.common.presentation.utils.SetStatusBarTextColor

@Composable
fun OrderScreen(
    viewModel: OrderViewModel,
    onBackClick: () -> Unit,
    onOrderClick: () -> Unit,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    OrderScreen(
        state = state,
        onBackClick = onBackClick,
        onOrderClick = onOrderClick
    )
}

@Composable
fun OrderScreen(
    state: OrderState,
    onBackClick: () -> Unit = {},
    onOrderClick: () -> Unit = {},
) {
    SetStatusBarTextColor(isDark = true)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(
                title = stringResource(R.string.order_name),
                needBack = true,
                onBackClick = onBackClick
            )
        },
        bottomBar = {
            PaymentSection(
                onOrderClick = onOrderClick
            )
        }
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
            var selectedTab by rememberSaveable { mutableIntStateOf(0) }
            Spacer(Modifier.height(24.dp))
            SlidingTabs(
                tabs = listOf("Deliver", "Pick Up"),
                selectedTab = selectedTab,
                onTabSelect = { selectedTab = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(43.dp)
            )
            Spacer(Modifier.height(16.dp))
            SectionDivider()
            Spacer(Modifier.height(16.dp))
            CartItem(testProducts.first().toDomain(), 1)
            Spacer(Modifier.height(16.dp))
            SectionDivider()
            Spacer(Modifier.height(16.dp))
        }
    }
}

@Preview
@Composable
fun OrderScreenPreview() {
    val products = mapOf(testProducts.first().toDomain() to 1)
    OrderScreen(
        state = OrderState.Success(products)
    )
}