package com.example.coffeeshop.features.main

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffeeshop.common.utils.safeLet
import com.example.coffeeshop.ui.theme.Brown
import com.example.coffeeshop.ui.theme.GreyLighter
import com.example.coffeeshop.ui.theme.RippleBrown

@Composable
fun BottomBar(
    items: List<BottomBarItemData>,
    currentDestination: String?,
    onItemSelect: (BottomBarItemData) -> Unit,
) {
    val navBarPadding = WindowInsets.navigationBars.asPaddingValues()
    val navBarBottomPadding = navBarPadding.calculateBottomPadding()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(24.dp, 24.dp, 0.dp, 0.dp)
            )
            .padding(bottom = navBarBottomPadding)
            .pointerInput(Unit) {
                awaitPointerEventScope {
                    while (true) {
                        awaitPointerEvent()
                    }
                }
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, top = 12.dp, end = 12.dp, bottom = 12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            items.forEach { data ->
                val itemDestination = data.destination::class.simpleName
                val isSelected = safeLet(currentDestination, itemDestination) { currentDestinationSafe, itemDestinationSafe ->
                    currentDestinationSafe.contains(itemDestinationSafe)
                }
                BottomBarItem(
                    data = data,
                    isSelected = isSelected,
                    onItemSelect = onItemSelect
                )
            }
        }
    }
}

@Composable
fun BottomBarItem(
    data: BottomBarItemData,
    isSelected: Boolean?,
    modifier: Modifier = Modifier,
    onItemSelect: (BottomBarItemData) -> Unit,
) {
    @OptIn(ExperimentalMaterial3Api::class)
    CompositionLocalProvider(LocalRippleConfiguration provides RippleBrown) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .size(width = 48.dp, height = 48.dp)
                .clip(CircleShape)
                .clickable { onItemSelect(data) }
        ) {
            isSelected?.let {
                Crossfade(isSelected) { isSelected ->
                    if (isSelected) {
                        SelectedIcon(data)
                    } else {
                        UnselectedIcon(data)
                    }
                }
            } ?: run {
                UnselectedIcon(data)
            }
        }
    }
}

@Composable
fun SelectedIcon(
    data: BottomBarItemData,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = data.iconSelected),
            tint = Brown,
            contentDescription = null
        )
        Spacer(
            modifier = Modifier.height(6.dp)
        )
        Box(
            modifier = Modifier
                .size(width = 10.dp, height = 5.dp)
                .background(
                    color = Brown,
                    shape = RoundedCornerShape(18.dp)
                )
        )
    }
}

@Composable
fun UnselectedIcon(
    data: BottomBarItemData,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = data.icon),
            tint = GreyLighter,
            contentDescription = null
        )
        Spacer(
            modifier = Modifier.height(11.dp)
        )
    }
}

@Preview(
    backgroundColor = 0xFF000000,
    showBackground = true
)
@Composable
fun BottomBarPreview() {
    BottomBar(
        items = bottomBarItems,
        currentDestination = Home::class.simpleName,
        onItemSelect = {}
    )
}