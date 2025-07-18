package com.uvarov.coffeeshop.common.presentation.cart

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.uvarov.coffeeshop.R
import com.uvarov.coffeeshop.common.data.product.toDomain
import com.uvarov.coffeeshop.common.data.testProducts
import com.uvarov.coffeeshop.common.domain.product.Product
import com.uvarov.coffeeshop.common.presentation.theme.CoffeeTheme
import com.uvarov.coffeeshop.common.presentation.theme.GreyNormalHover
import com.uvarov.coffeeshop.common.presentation.theme.SoraFontFamily
import com.uvarov.coffeeshop.common.presentation.utils.categoryName

@Composable
fun CartItem(
    product: Product,
    quantity: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = product.image,
            contentDescription = "Product image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(54.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(Modifier.width(16.dp))
        Column {
            Text(
                text = product.name,
                style = CoffeeTheme.typography.sectionTitle
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = categoryName(product.category),
                style = CoffeeTheme.typography.categoryName
            )
        }
        Spacer(Modifier.weight(1f))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.quantity_decrease),
                contentDescription = "Decrease quantity",
                tint = Color.Unspecified,
                modifier = Modifier
                    .clickable { }
            )
            Text(
                text = quantity.toString(),
                color = GreyNormalHover,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = SoraFontFamily,
                lineHeight = 21.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(42.dp)
            )
            Icon(
                painter = painterResource(R.drawable.quantity_increase),
                contentDescription = "Increase quantity",
                tint = Color.Unspecified,
                modifier = Modifier
                    .clickable { }
            )
        }
    }
}

@Preview
@Composable
fun CartItemPreview() {
    val product = testProducts.first().toDomain()
    CartItem(
        product,
        quantity = 1
    )
}