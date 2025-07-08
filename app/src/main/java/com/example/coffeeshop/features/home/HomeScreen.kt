package com.example.coffeeshop.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffeeshop.R
import com.example.coffeeshop.ui.theme.Brown
import com.example.coffeeshop.ui.theme.GreyLighter
import com.example.coffeeshop.ui.theme.SurfaceLight

@Composable
fun HomeScreen(onItemClick: (String) -> Unit) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomBar()
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = SurfaceLight)
        ) {

        }
    }
}

data class BottomBarItemData(
    val id: Int,
    val icon: Int,
    val iconSelected: Int,
)

val bottomBarItems = listOf(
    BottomBarItemData(0, R.drawable.home, R.drawable.home_filled),
    BottomBarItemData(1, R.drawable.heart, R.drawable.heart_filled),
    BottomBarItemData(2, R.drawable.bag, R.drawable.bag_filled),
    BottomBarItemData(3, R.drawable.notification, R.drawable.notification_filled)
)

@Composable
fun BottomBar(
    items: List<BottomBarItemData> = bottomBarItems,
) {
    var selectedItem by remember { mutableIntStateOf(0) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(24.dp, 24.dp, 0.dp, 0.dp)
            )
            .padding(WindowInsets.navigationBars.asPaddingValues())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, top = 12.dp, end = 12.dp, bottom = 12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            items.forEach { data ->
                BottomBarItem(
                    data = data,
                    isSelected = data.id == selectedItem,
                    modifier = Modifier
                        .size(width = 48.dp, height = 48.dp)
                ) { id -> selectedItem = id }
            }
        }
    }
}

@Composable
fun BottomBarItem(
    data: BottomBarItemData,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onItemSelected: (Int) -> Unit
) {
    Column(
        modifier = modifier
            .clickable { onItemSelected(data.id) },
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
    widthDp = 360,
    heightDp = 800
)
@Composable
fun HomeScreenPreview() {
    HomeScreen(onItemClick = {})
}
