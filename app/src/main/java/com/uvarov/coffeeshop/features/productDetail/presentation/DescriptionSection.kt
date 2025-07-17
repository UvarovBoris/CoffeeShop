package com.uvarov.coffeeshop.features.productDetail.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvarov.coffeeshop.R
import com.uvarov.coffeeshop.common.data.testProducts
import com.uvarov.coffeeshop.common.data.product.toDomain
import com.uvarov.coffeeshop.common.domain.product.Product
import com.uvarov.coffeeshop.common.presentation.theme.CoffeeTheme
import com.uvarov.coffeeshop.common.presentation.theme.GreyLighter
import com.uvarov.coffeeshop.common.presentation.theme.SoraFontFamily

@Composable
fun DescriptionSection(
    product: Product,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.product_detail_description_title),
            style = CoffeeTheme.typography.detailSectionTitle
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = product.description,
            color = GreyLighter,
            fontSize = 14.sp,
            fontWeight = FontWeight.Light,
            fontFamily = SoraFontFamily,
            lineHeight = 21.sp,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
    }
}


@Preview
@Composable
fun DescriptionSectionPreview() {
    val product = testProducts.first().toDomain()
    DescriptionSection(
        product = product
    )
}