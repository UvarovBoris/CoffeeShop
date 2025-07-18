package com.uvarov.coffeeshop.common.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.uvarov.coffeeshop.common.presentation.theme.SurfaceLightActive

@Composable
fun SectionDivider() {
    HorizontalDivider(
        thickness = 1.dp,
        color = SurfaceLightActive,
        modifier = Modifier
            .padding(horizontal = 16.dp)
    )
}