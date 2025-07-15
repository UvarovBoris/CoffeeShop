package com.example.coffeeshop.features.order

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.layout.boundsInParent
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeshop.ui.theme.Brown
import com.example.coffeeshop.ui.theme.GreyNormalActive
import com.example.coffeeshop.ui.theme.RippleBrown
import com.example.coffeeshop.ui.theme.SurfaceWhite
import com.example.coffeeshop.ui.theme.SurfaceWhiteActive
import com.example.coffeeshop.ui.toDp

@Composable
fun SlidingTabs(
    tabs: List<String>,
    selectedTab: Int,
    onTabSelect: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val density = LocalDensity.current
    val tabRect = remember { mutableStateMapOf<Int, Rect>() }

    val targetRect = tabRect[selectedTab]
    val tabWidth = targetRect?.width?.toDp(density) ?: 0.dp

    val tabLeft by animateIntAsState(
        targetValue = targetRect?.left?.toInt() ?: 0,
        label = "leftAnimation"
    )

    Box(
        modifier = modifier
            .background(
                color = SurfaceWhiteActive,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(tabWidth)
                .offset { IntOffset(x = tabLeft, y = 0) }
                .background(
                    color = Brown,
                    shape = RoundedCornerShape(8.dp)
                )
        )
        Row(
            modifier = Modifier
                .fillMaxHeight()
        ) {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    text = tab,
                    isSelected = index == selectedTab,
                    modifier = Modifier.weight(1f),
                    onClick = { onTabSelect.invoke(index) },
                    onLayout = { rect -> tabRect[index] = rect }
                )
            }
        }
    }
}

@Composable
fun Tab(
    text: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    onLayout: (Rect) -> Unit,
) {
    @OptIn(ExperimentalMaterial3Api::class)
    CompositionLocalProvider(LocalRippleConfiguration provides RippleBrown) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .fillMaxHeight()
                .clip(RoundedCornerShape(8.dp))
                .clickable(onClick = onClick)
                .onGloballyPositioned { layoutCoordinates ->
                    val rect = layoutCoordinates.boundsInParent()
                    onLayout.invoke(rect)
                }
        ) {
            val textColor by animateColorAsState(
                targetValue = if (isSelected) SurfaceWhite else GreyNormalActive
            )
            Text(
                text = text,
                color = textColor,
                fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 19.2.sp
            )
        }
    }
}

@Preview
@Composable
fun SlidingTabsPreview() {
    SlidingTabs(
        tabs = listOf("Tab 1", "Tab 2"),
        selectedTab = 0,
        onTabSelect = {},
        modifier = Modifier.height(43.dp)
    )
}