package com.example.coffeeshop.common.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffeeshop.R
import com.example.coffeeshop.ui.theme.CoffeeTheme

@Composable
fun TopBar(
    title: String,
    modifier: Modifier = Modifier,
    rightButton: @Composable (() -> Unit)? = null,
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
        TopBarButton(
            icon = R.drawable.arrow_left,
            contentDescription = "Back",
            onClick = onBackClick
        )
        Text(
            text = title,
            style = CoffeeTheme.typography.topBarTitle,
            modifier = Modifier.weight(1f)
        )
        if (rightButton != null) {
            rightButton()
        } else {
            Spacer(modifier = Modifier.size(44.dp))
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