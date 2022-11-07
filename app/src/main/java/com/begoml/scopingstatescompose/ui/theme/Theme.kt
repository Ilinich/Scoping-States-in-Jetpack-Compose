package com.begoml.scopingstatescompose.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val Color = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200
)

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = Color,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
