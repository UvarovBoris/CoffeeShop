package com.example.coffeeshop.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.coffeeshop.R
import com.example.coffeeshop.data.Category
import com.example.coffeeshop.data.Category.*

@Composable
fun categoryName(category: Category): String {
    return when (category) {
        AllCoffee -> stringResource(R.string.all_coffee)
        Macchiato -> stringResource(R.string.macchiato)
        Latte -> stringResource(R.string.latte)
        Americano -> stringResource(R.string.americano)
        Mocha -> stringResource(R.string.mocha)
        Espresso -> stringResource(R.string.espresso)
        Cappuccino -> stringResource(R.string.cappuccino)
    }
}