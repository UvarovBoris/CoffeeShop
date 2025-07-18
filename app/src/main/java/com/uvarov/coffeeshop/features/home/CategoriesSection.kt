package com.uvarov.coffeeshop.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvarov.coffeeshop.common.data.product.ProductCategory
import com.uvarov.coffeeshop.common.data.testCategories
import com.uvarov.coffeeshop.common.presentation.utils.categoryName
import com.uvarov.coffeeshop.common.presentation.theme.Brown
import com.uvarov.coffeeshop.common.presentation.theme.GreyNormal
import com.uvarov.coffeeshop.common.presentation.theme.RippleBrown
import com.uvarov.coffeeshop.common.presentation.theme.SoraFontFamily

@Composable
fun CategoriesSection(
    categories: List<ProductCategory>,
    selectedCategory: ProductCategory,
    modifier: Modifier = Modifier,
    onCategorySelected: (ProductCategory) -> Unit,
) {
    @OptIn(ExperimentalMaterial3Api::class)
    CompositionLocalProvider(LocalRippleConfiguration provides RippleBrown) {
        val scrollState = rememberScrollState()
        Row(
            modifier = modifier
                .horizontalScroll(scrollState),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            categories.forEach {
                CategoryItem(
                    category = it,
                    isSelected = selectedCategory == it,
                    onCategorySelected
                )
            }
        }
    }
}

@Composable
fun CategoryItem(
    category: ProductCategory,
    isSelected: Boolean,
    onClick: (ProductCategory) -> Unit,
) {
    Text(
        text = categoryName(category),
        fontSize = 14.sp,
        color = if (isSelected) Color.White else GreyNormal,
        fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
        fontFamily = SoraFontFamily,
        modifier = Modifier
            .clip(shape = RoundedCornerShape(6.dp))
            .background(
                color = if (isSelected) Brown else Color(0x60EDEDED),
            )
            .clickable(onClick = { onClick(category) })
            .padding(horizontal = 8.dp, vertical = 4.dp)
    )
}

@Preview
@Composable
fun CategoriesSectionPreview() {
    CategoriesSection(
        categories = testCategories,
        selectedCategory = testCategories.first(),
        onCategorySelected = {}
    )
}