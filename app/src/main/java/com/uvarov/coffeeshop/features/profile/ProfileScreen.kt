package com.uvarov.coffeeshop.features.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvarov.coffeeshop.common.presentation.utils.SetStatusBarTextColor
import com.uvarov.coffeeshop.common.presentation.theme.SurfaceLight

@Composable
fun ProfileScreen(
    padding: PaddingValues,
) {
    SetStatusBarTextColor(isDark = true)
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
    }
}

@Preview(
    widthDp = 360,
    heightDp = 800
)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(
        padding = PaddingValues(0.dp)
    )
}