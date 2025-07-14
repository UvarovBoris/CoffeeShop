package com.example.coffeeshop.ui.theme

import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RippleConfiguration

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