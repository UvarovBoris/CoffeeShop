package com.example.coffeeshop.features.productDetail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeshop.R
import com.example.coffeeshop.ui.theme.GreyNormalActive
import com.example.coffeeshop.ui.theme.GreyNormalHover
import com.example.coffeeshop.ui.theme.SoraFontFamily

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
) {
    val statusBarPadding = WindowInsets.statusBars.asPaddingValues()
    val statusBarTopPadding = statusBarPadding.calculateTopPadding()
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                top = 24.dp + statusBarTopPadding,
                start = 24.dp,
                end = 24.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(12.dp))
                .clickable(onClick = onBackClick)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.arrow_left),
                contentDescription = "Back",
                tint = GreyNormalHover,
            )
        }
        Text(
            text = stringResource(R.string.product_detail_name),
            color = GreyNormalActive,
            fontSize = 16.sp,
            lineHeight = 19.2.sp,
            fontFamily = SoraFontFamily,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)
        )
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(12.dp))
                .clickable(onClick = {})
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.heart),
                contentDescription = "Add to favorites",
                tint = GreyNormalHover,
            )
        }
    }
}