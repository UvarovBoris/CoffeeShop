package com.example.coffeeshop.features.productDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeshop.R
import com.example.coffeeshop.ui.theme.Brown
import com.example.coffeeshop.ui.theme.BrownLight
import com.example.coffeeshop.ui.theme.CoffeeTheme
import com.example.coffeeshop.ui.theme.GreyNormalActive
import com.example.coffeeshop.ui.theme.RippleBrown
import com.example.coffeeshop.ui.theme.SoraFontFamily
import com.example.coffeeshop.ui.theme.SurfaceLightActive
import com.example.coffeeshop.ui.theme.SurfaceWhite

@Composable
fun SizeSection(
    items: List<String>,
    selectedItem: String,
    onItemSelect: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.product_detail_size_title),
            style = CoffeeTheme.typography.detailSectionTitle
        )
        Spacer(Modifier.height(16.dp))
        SizesRow(
            items = items,
            selectedItem = selectedItem,
            onItemSelect = onItemSelect
        )
    }
}

@Composable
private fun SizesRow(
    items: List<String>,
    selectedItem: String,
    onItemSelect: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(41.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items.forEach {
            SizeItem(
                text = it,
                isSelected = it == selectedItem,
                onClick = { onItemSelect(it) },
                modifier = modifier.weight(1f)
            )
        }
    }
}

@Composable
fun SizeItem(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    @OptIn(ExperimentalMaterial3Api::class)
    CompositionLocalProvider(LocalRippleConfiguration provides RippleBrown) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(12.dp))
                .clickable(onClick = onClick)
                .background(
                    color = if (isSelected) BrownLight else SurfaceWhite
                )
                .border(
                    width = 1.dp,
                    color = if (isSelected) Brown else SurfaceLightActive,
                    shape = RoundedCornerShape(12.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = if (isSelected) Brown else GreyNormalActive,
                fontSize = 14.sp,
                fontFamily = SoraFontFamily,
                lineHeight = 21.sp
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF404040,
)
@Composable
fun SizeSectionPreview() {
    SizeSection(
        items = listOf("S", "M", "L"),
        selectedItem = "S",
        onItemSelect = {}
    )
}