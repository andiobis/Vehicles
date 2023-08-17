package com.example.fleetiovehicles.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val TargetLight = lightColors(
    primary = RedDark,
    primaryVariant = Red,
    secondary = Green,
    background = Color.White,
    surface = Color.White,
    error = Red,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black,
    onError = Color.White
)

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = TargetLight,
        typography = Typography,
        content = content
    )
}

