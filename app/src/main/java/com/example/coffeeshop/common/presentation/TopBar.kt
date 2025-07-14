package com.example.coffeeshop.common.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffeeshop.R
import com.example.coffeeshop.ui.theme.CoffeeTheme

@Composable
fun TopBar(
    title: String,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
) {
    val statusBarPadding = WindowInsets.statusBars.asPaddingValues()
    val statusBarTopPadding = statusBarPadding.calculateTopPadding()
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                top = 24.dp + statusBarTopPadding,
                start = 24.dp,
                end = 24.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(12.dp))
                .clickable(onClick = onBackClick)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.arrow_left),
                contentDescription = "Back",
                tint = CoffeeTheme.color.onTopBar,
            )
        }
        Text(
            text = title,
            style = CoffeeTheme.typography.topBarTitle,
            modifier = Modifier.weight(1f)
        )
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(12.dp))
                .clickable(onClick = {})
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.heart),
                contentDescription = "Add to favorites",
                tint = CoffeeTheme.color.onTopBar,
            )
        }
    }
}

@Preview
@Composable
fun TopBarPreview() {
    TopBar(
        title = "Title",
        onBackClick = {}
    )
}