package com.uvarov.coffeeshop.common.presentation

import androidx.annotation.DrawableRes
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.uvarov.coffeeshop.common.presentation.theme.CoffeeTheme

@Composable
fun TopBarIconButton(
    @DrawableRes icon: Int,
    contentDescription: String,
    modifier: Modifier = Modifier,
    tint: Color = CoffeeTheme.color.onTopBar,
    onClick: () -> Unit = {},
) {
    TopBarButton(
        modifier = modifier,
        onClick = onClick
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = contentDescription,
            tint = tint,
        )
    }
}