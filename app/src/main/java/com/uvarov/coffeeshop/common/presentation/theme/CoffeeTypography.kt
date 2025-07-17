package com.uvarov.coffeeshop.common.presentation.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.uvarov.coffeeshop.R

val SoraFontFamily = FontFamily(
    Font(R.font.sora_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.sora_semi_bold, FontWeight.SemiBold, FontStyle.Normal),
    Font(R.font.sora_light, FontWeight.Light, FontStyle.Normal),
)

object CoffeeTypography {
    val topBarTitle = TextStyle(
        color = CoffeeColor.onTopBar,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = SoraFontFamily,
        textAlign = TextAlign.Center,
        lineHeight = 19.2.sp,
    )

    val detailSectionTitle = TextStyle(
        color = CoffeeColor.title,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = SoraFontFamily,
        lineHeight = 24.sp,
    )

    val buttonText = TextStyle(
        color = SurfaceWhite,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = SoraFontFamily,
        lineHeight = 24.sp
    )
}