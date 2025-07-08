package com.example.coffeeshop.features.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeshop.data.CategoryData
import com.example.coffeeshop.data.categories
import com.example.coffeeshop.ui.theme.Brown
import com.example.coffeeshop.ui.theme.GreyNormal
import com.example.coffeeshop.ui.theme.SoraFontFamily

@Composable
fun CategoriesSection(
    categories: List<CategoryData>,
    selectedCategory: CategoryData,
    modifier: Modifier = Modifier,
    onCategoryClick: (CategoryData) -> Unit
) {
    val scrollState = rememberScrollState()
    Row(
        modifier = modifier
            .horizontalScroll(scrollState),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        categories.forEach {
            CategoryItem(
                data = it,
                isSelected = selectedCategory == it,
                onCategoryClick
            )
        }
    }
}

@Composable
fun CategoryItem(
    data: CategoryData,
    isSelected: Boolean,
    onClick: (CategoryData) -> Unit
) {
    Text(
        text = data.name,
        fontSize = 14.sp,
        color = if (isSelected) Color.White else GreyNormal,
        fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
        fontFamily = SoraFontFamily,
        modifier = Modifier
            .background(
                color = if (isSelected) Brown else Color(0x60EDEDED),
                shape = RoundedCornerShape(6.dp)
            )
            .clickable(onClick = { onClick(data) })
            .padding(horizontal = 8.dp, vertical = 4.dp)
    )
}

@Preview
@Composable
fun CategoriesSectionPreview() {
    CategoriesSection(
        categories = categories,
        selectedCategory = categories.first(),
        onCategoryClick = {}
    )
}