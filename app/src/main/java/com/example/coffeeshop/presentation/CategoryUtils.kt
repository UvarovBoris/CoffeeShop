package com.example.coffeeshop.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.coffeeshop.R
import com.example.coffeeshop.data.Category

@Composable
fun categoryName(category: Category): String {
    return when (category) {
        Category.Macchiato -> stringResource(R.string.macchiato)
        Category.Latte -> stringResource(R.string.latte)
        Category.Americano -> stringResource(R.string.americano)
        Category.Mocha -> stringResource(R.string.mocha)
        Category.Espresso -> stringResource(R.string.espresso)
        Category.Cappuccino -> stringResource(R.string.cappuccino)
    }
}