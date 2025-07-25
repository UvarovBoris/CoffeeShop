package com.uvarov.coffeeshop.common.presentation.product

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.uvarov.coffeeshop.R
import com.uvarov.coffeeshop.common.data.product.toDomain
import com.uvarov.coffeeshop.common.data.testProducts
import com.uvarov.coffeeshop.common.domain.product.Product
import com.uvarov.coffeeshop.common.presentation.theme.Black
import com.uvarov.coffeeshop.common.presentation.theme.Brown
import com.uvarov.coffeeshop.common.presentation.theme.GreyLighter
import com.uvarov.coffeeshop.common.presentation.theme.GreyNormal
import com.uvarov.coffeeshop.common.presentation.theme.SoraFontFamily
import com.uvarov.coffeeshop.common.presentation.theme.SurfaceWhite
import com.uvarov.coffeeshop.common.presentation.utils.categoryName

@Composable
fun ProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    onClick: (Product) -> Unit = {},
    onAddToCartClick: (Product) -> Unit = {},
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(16.dp))
            .background(color = SurfaceWhite)
            .clickable(onClick = { onClick(product) })
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 8.dp,
                bottom = 12.dp
            )
    ) {
        Box {
            AsyncImage(
                model = product.image,
                contentDescription = "Product image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(140f / 128f)
                    .clip(RoundedCornerShape(12.dp))
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            topStart = 0.dp,
                            topEnd = 12.dp,
                            bottomStart = 24.dp,
                            bottomEnd = 0.dp
                        )
                    )
                    .background(color = Color(0x4D313131))
                    .padding(8.dp)
                    .align(Alignment.TopEnd)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = product.rating.toString(),
                    color = SurfaceWhite,
                    fontSize = 8.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = SoraFontFamily,
                    lineHeight = 12.sp
                )

            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = product.name,
            color = GreyNormal,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = SoraFontFamily,
            lineHeight = 24.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = categoryName(product.category),
            color = GreyLighter,
            fontSize = 12.sp,
            fontFamily = SoraFontFamily,
            lineHeight = 14.4.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "$ ${product.variants[1].price}",
                color = Black,
                fontSize = 18.sp,
                fontFamily = SoraFontFamily,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 27.sp
            )
            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(color = Brown)
                    .clickable(onClick = { onAddToCartClick(product) })
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.plus),
                    contentDescription = "Add",
                    tint = Color.White
                )
            }
        }
    }
}

@Preview(
    backgroundColor = 0xFF000000,
    showBackground = true,
    widthDp = 156
)
@Composable
fun ProductItemPreview() {
    ProductItem(
        product = testProducts.first().toDomain()
    )
}