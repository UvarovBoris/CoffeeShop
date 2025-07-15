package com.example.coffeeshop.features.order

import androidx.compose.animation.core.animateDpAsState
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.layout.boundsInParent
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
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
    modifier: Modifier = Modifier,
) {
    val density = LocalDensity.current
    val tabMeta = remember { mutableStateMapOf<Int, Rect>() }
    var selectedTab by remember { mutableIntStateOf(0) }

    val targetRect = tabMeta[selectedTab]
    val tabWidth = targetRect?.width?.toDp(density) ?: 0.dp

    val tabLeft by animateDpAsState(
        targetValue = targetRect?.left?.toDp(density) ?: 0.dp,
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
                .offset(x = tabLeft)
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
                    onClick = { selectedTab = index },
                    onLayout = { rect -> tabMeta[index] = rect }
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
            Text(
                text = text,
                color = if (isSelected) SurfaceWhite else GreyNormalActive,
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
        modifier = Modifier.height(43.dp)
    )
}