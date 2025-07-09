package com.example.coffeeshop.features.main

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
import com.example.coffeeshop.ui.theme.Brown
import com.example.coffeeshop.ui.theme.GreyLighter
import com.example.coffeeshop.ui.theme.RippleBrown

@Composable
fun BottomBar(
    items: List<BottomBarItemData>,
    currentDestination: String?,
    onItemSelected: (BottomBarItemData) -> Unit
) {
    val navBarPadding = WindowInsets.navigationBars.asPaddingValues()
    val navBarBottomPadding = navBarPadding.calculateBottomPadding()

    @OptIn(ExperimentalMaterial3Api::class)
    CompositionLocalProvider(LocalRippleConfiguration provides RippleBrown) {
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
                    val destinationName = data.destination::class.simpleName
                    val isSelected = currentDestination?.contains(destinationName ?: "") == true
                    BottomBarItem(
                        data = data,
                        isSelected = isSelected,
                        onItemSelected = onItemSelected
                    )
                }
            }
        }
    }
}

@Composable
fun BottomBarItem(
    data: BottomBarItemData,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onItemSelected: (BottomBarItemData) -> Unit
) {
    Column(
        modifier = modifier
            .size(width = 48.dp, height = 48.dp)
            .clip(CircleShape)
            .clickable { onItemSelected(data) },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = if (isSelected) data.iconSelected else data.icon),
            tint = if (isSelected) Brown else GreyLighter,
            contentDescription = null
        )
        Spacer(
            modifier = Modifier.height(if (isSelected) 6.dp else 11.dp)
        )
        if (isSelected) {
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
        onItemSelected = {}
    )
}