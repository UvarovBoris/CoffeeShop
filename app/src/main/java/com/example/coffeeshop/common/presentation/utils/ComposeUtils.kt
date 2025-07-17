package com.example.coffeeshop.common.presentation.utils

import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp

fun Float.toDp(density: Density): Dp = with(density) { this@toDp.toDp() }