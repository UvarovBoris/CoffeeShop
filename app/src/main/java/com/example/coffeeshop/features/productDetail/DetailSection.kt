package com.example.coffeeshop.features.productDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeshop.R
import com.example.coffeeshop.data.ProductData
import com.example.coffeeshop.data.allProducts
import com.example.coffeeshop.ui.theme.GreyLighter
import com.example.coffeeshop.ui.theme.GreyNormalActive
import com.example.coffeeshop.ui.theme.GreyNormalHover
import com.example.coffeeshop.ui.theme.SoraFontFamily

@Composable
fun DetailSection(
    product: ProductData,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = product.name,
            color = GreyNormalActive,
            fontSize = 20.sp,
            fontFamily = SoraFontFamily,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 30.sp,
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = product.description,
            color = GreyLighter,
            fontSize = 12.sp,
            fontFamily = SoraFontFamily,
            lineHeight = 14.4.sp,
        )
        Spacer(Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.star),
                contentDescription = "Rating",
                tint = Color.Unspecified,
                modifier = Modifier.size(20.dp)
            )
            Spacer(Modifier.width(4.dp))
            Text(
                text = product.rating.toString(),
                color = GreyNormalHover,
                fontSize = 16.sp,
                fontFamily = SoraFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview
@Composable
fun DetailSectionPreview() {
    DetailSection(
        product = allProducts.first()
    )
}