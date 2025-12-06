package com.mhd_07.compose_training.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class AppDimensions(
    val spacing_xxs: Dp = 4.dp,
    val spacing_xs: Dp = 8.dp,
    val spacing_s: Dp = 16.dp,
    val spacing_m: Dp = 24.dp,
    val spacing_l: Dp = 32.dp,
    val spacing_xl: Dp = 48.dp,
    val spacing_xxl: Dp = 56.dp,
    val spacing_xxxl: Dp = 64.dp,
    val spacing_xxxxl: Dp = 96.dp
)

internal val LocalDim = staticCompositionLocalOf { AppDimensions() }
