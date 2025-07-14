package com.example.coffeeshop.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.coffeeshop.R

val SoraFontFamily = FontFamily(
    Font(R.font.sora_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.sora_semi_bold, FontWeight.SemiBold, FontStyle.Normal),
)

object CoffeeTypography {
    val topBarTitle = TextStyle(
        color = CoffeeTheme.color.onTopBar,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = SoraFontFamily,
        textAlign = TextAlign.Center,
        lineHeight = 19.2.sp,
    )
}