package com.uvarov.coffeeshop.common.presentation.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.uvarov.coffeeshop.R
import com.uvarov.coffeeshop.common.data.product.ProductCategory
import com.uvarov.coffeeshop.common.data.product.ProductCategory.AllCoffee
import com.uvarov.coffeeshop.common.data.product.ProductCategory.Americano
import com.uvarov.coffeeshop.common.data.product.ProductCategory.Cappuccino
import com.uvarov.coffeeshop.common.data.product.ProductCategory.Espresso
import com.uvarov.coffeeshop.common.data.product.ProductCategory.Latte
import com.uvarov.coffeeshop.common.data.product.ProductCategory.Macchiato
import com.uvarov.coffeeshop.common.data.product.ProductCategory.Mocha
import com.uvarov.coffeeshop.common.domain.product.ProductSize
import com.uvarov.coffeeshop.common.domain.product.ProductSize.Large
import com.uvarov.coffeeshop.common.domain.product.ProductSize.Medium
import com.uvarov.coffeeshop.common.domain.product.ProductSize.Small

@Composable
fun categoryName(category: ProductCategory): String {
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