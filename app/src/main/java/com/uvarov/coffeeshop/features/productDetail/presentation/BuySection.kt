package com.uvarov.coffeeshop.features.productDetail.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvarov.coffeeshop.R
import com.uvarov.coffeeshop.common.data.testProducts
import com.uvarov.coffeeshop.common.data.product.toDomain
import com.uvarov.coffeeshop.common.domain.product.ProductVariant
import com.uvarov.coffeeshop.common.presentation.theme.Brown
import com.uvarov.coffeeshop.common.presentation.theme.CoffeeTheme
import com.uvarov.coffeeshop.common.presentation.theme.GreyLightHover
import com.uvarov.coffeeshop.common.presentation.theme.SoraFontFamily
import com.uvarov.coffeeshop.common.presentation.theme.SurfaceWhite

@Composable
fun BuySection(
    variant: ProductVariant,
    onBuyClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val navBarPadding = WindowInsets.navigationBars.asPaddingValues()
    val navBarBottomPadding = navBarPadding.calculateBottomPadding()
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .background(color = SurfaceWhite)
            .padding(
                start = 24.dp,
                end = 24.dp,
                top = 16.dp,
                bottom = 16.dp + navBarBottomPadding
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(Modifier.width(76.dp)) {
            Text(
                text = stringResource(R.string.product_detail_price),
                color = GreyLightHover,
                fontSize = 14.sp,
                fontFamily = SoraFontFamily,
                lineHeight = 16.8.sp,
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = "$ ${variant.price}",
                color = Brown,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = SoraFontFamily,
                lineHeight = 27.sp,
            )
        }
        Spacer(modifier.width(34.dp))
        Button(
            onClick = onBuyClick,
            shape = RoundedCornerShape(16.dp),
            contentPadding = PaddingValues(20.dp, 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Brown),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.product_detail_buy_button),
                style = CoffeeTheme.typography.buttonText,
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
fun BuySectionPreview() {
    val product = testProducts.first().toDomain()
    BuySection(
        variant = product.variants.first(),
        onBuyClick = {}
    )
}