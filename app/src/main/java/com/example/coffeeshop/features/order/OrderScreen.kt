package com.example.coffeeshop.features.order

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffeeshop.R
import com.example.coffeeshop.common.presentation.TopBar
import com.example.coffeeshop.ui.SetStatusBarTextColor
import com.example.coffeeshop.ui.theme.SurfaceLight

@Composable
fun OrderScreen(
    onBackClick: () -> Unit,
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
            Spacer(Modifier.height(24.dp))
            SlidingTabs(
                tabs = listOf("Deliver", "Pick Up"),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(43.dp)
            )
        }
    }
}

@Preview
@Composable
fun OrderScreenPreview() {
    OrderScreen(onBackClick = {})
}