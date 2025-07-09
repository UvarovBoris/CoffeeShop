package com.example.coffeeshop.features.productDetail

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
import com.example.coffeeshop.R
import com.example.coffeeshop.data.ProductData
import com.example.coffeeshop.data.allProducts
import com.example.coffeeshop.ui.theme.Brown
import com.example.coffeeshop.ui.theme.GreyLightHover
import com.example.coffeeshop.ui.theme.SoraFontFamily
import com.example.coffeeshop.ui.theme.SurfaceWhite

@Composable
fun BuySection(
    product: ProductData,
    modifier: Modifier = Modifier,
    onBuyClick: () -> Unit,
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
        Column {
            Text(
                text = stringResource(R.string.product_detail_price),
                color = GreyLightHover,
                fontSize = 14.sp,
                fontFamily = SoraFontFamily,
                lineHeight = 16.8.sp,
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = product.price,
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
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = SoraFontFamily,
                lineHeight = 24.sp
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
    BuySection(
        product = allProducts.first(),
        onBuyClick = {}
    )
}