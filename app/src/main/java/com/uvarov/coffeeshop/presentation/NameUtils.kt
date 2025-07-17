package com.uvarov.coffeeshop.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.uvarov.coffeeshop.R
import com.uvarov.coffeeshop.data.Category
import com.uvarov.coffeeshop.data.Category.AllCoffee
import com.uvarov.coffeeshop.data.Category.Americano
import com.uvarov.coffeeshop.data.Category.Cappuccino
import com.uvarov.coffeeshop.data.Category.Espresso
import com.uvarov.coffeeshop.data.Category.Latte
import com.uvarov.coffeeshop.data.Category.Macchiato
import com.uvarov.coffeeshop.data.Category.Mocha
import com.uvarov.coffeeshop.domain.ProductSize
import com.uvarov.coffeeshop.domain.ProductSize.Large
import com.uvarov.coffeeshop.domain.ProductSize.Medium
import com.uvarov.coffeeshop.domain.ProductSize.Small

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