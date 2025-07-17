package com.example.coffeeshop.features.order

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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeshop.R
import com.example.coffeeshop.ui.theme.Brown
import com.example.coffeeshop.ui.theme.CoffeeTypography
import com.example.coffeeshop.ui.theme.GreyNormalActive
import com.example.coffeeshop.ui.theme.SoraFontFamily
import com.example.coffeeshop.ui.theme.SurfaceWhite

@Composable
fun PaymentSection(
    modifier: Modifier = Modifier,
    onOrderClick: () -> Unit = {},
) {
    val navBarPadding = WindowInsets.navigationBars.asPaddingValues()
    val navBarBottomPadding = navBarPadding.calculateBottomPadding()
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .background(color = SurfaceWhite)
            .padding(
                start = 24.dp,
                end = 24.dp,
                top = 16.dp,
                bottom = 16.dp + navBarBottomPadding
            )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.wallet),
                contentDescription = "Wallet Icon",
                tint = Brown
            )
            Spacer(Modifier.width(16.dp))
            Column {
                Text(
                    text = "Cash/Wallet",
                    color = GreyNormalActive,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = SoraFontFamily,
                    lineHeight = 16.8.sp,
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = "$ 5.53",
                    color = Brown,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = SoraFontFamily,
                    lineHeight = 18.sp,
                )
            }
        }
        Spacer(Modifier.height(8.dp))
        Button(
            onClick = onOrderClick,
            shape = RoundedCornerShape(16.dp),
            contentPadding = PaddingValues(20.dp, 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Brown),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.order_payment_button),
                style = CoffeeTypography.buttonText
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
fun PaymentSectionPreview() {
    PaymentSection()
}