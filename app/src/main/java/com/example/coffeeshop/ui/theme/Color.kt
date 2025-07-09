package com.example.coffeeshop.ui.theme

import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RippleConfiguration
import androidx.compose.ui.graphics.Color

val Black = Color(0xFF050505)
val Brown = Color(0xFFC67C4E)
val Almond = Color(0xFFEDD6C8)
val MineShaft = Color(0xFF313131)
val Mercury = Color(0xFFE3E3E3)
val Fantasy = Color(0xFFF9F2ED)

val GreyNormal = Color(0xFF313131)
val GreyNormalHover = Color(0xFF2A2A2A)
val GreyNormalActive = Color(0xFF2A2A2A)

val GreyLighter = Color(0xFFA2A2A2)
val GreyLightHover = Color(0xFF909090)

val SurfaceWhite = Color(0xFFFFFFFF)
val SurfaceLight = Color(0xFFF9F9F9)
val SurfaceLightActive = Color(0xFFE3E3E3)
val SurfaceNormalActive = Color(0xFFD8D8D8)

@OptIn(ExperimentalMaterial3Api::class)
val RippleGrey = RippleConfiguration(
    color = GreyNormal,
    rippleAlpha = RippleAlpha(
        0.3f,
        0.3f,
        0.3f,
        0.3f
    )
)

@OptIn(ExperimentalMaterial3Api::class)
val RippleBrown = RippleConfiguration(
    color = Brown,
    rippleAlpha = RippleAlpha(
        0.3f,
        0.3f,
        0.3f,
        0.3f
    )
)