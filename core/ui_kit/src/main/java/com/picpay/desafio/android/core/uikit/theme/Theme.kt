package com.picpay.desafio.android.core.uikit.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

private val ColorPalette = darkColors(
    primary = ColorPrimary,
    primaryVariant = ColorPrimaryDark,
    secondary = ColorAccent,
    secondaryVariant = ColorPrimaryLight,
    onPrimary = ColorWhite,
    onSecondary = ColorDetail
)

@Composable
fun DesafioandroidTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = ColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}