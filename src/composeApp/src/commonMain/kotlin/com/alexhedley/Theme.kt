package com.alexhedley

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val AppColorScheme = lightColorScheme(
    primary = Color(0xFF673AB7),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFEDE7F6),
    onPrimaryContainer = Color(0xFF4527A0),
    surface = Color(0xFFFFFFFF),
    background = Color(0xFFF5F5F5),
)

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = AppColorScheme,
        content = content
    )
}
