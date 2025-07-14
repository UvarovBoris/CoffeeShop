package com.example.coffeeshop.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.coffeeshop.R
import com.example.coffeeshop.data.Category
import com.example.coffeeshop.data.Category.AllCoffee
import com.example.coffeeshop.data.Category.Americano
import com.example.coffeeshop.data.Category.Cappuccino
import com.example.coffeeshop.data.Category.Espresso
import com.example.coffeeshop.data.Category.Latte
import com.example.coffeeshop.data.Category.Macchiato
import com.example.coffeeshop.data.Category.Mocha
import com.example.coffeeshop.domain.ProductSize
import com.example.coffeeshop.domain.ProductSize.Large
import com.example.coffeeshop.domain.ProductSize.Medium
import com.example.coffeeshop.domain.ProductSize.Small

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

@Composable
fun sizeName(productSize: ProductSize): String {
    return when (productSize) {
        Small -> "S"
        Medium -> "M"
        Large -> "L"
    }
}