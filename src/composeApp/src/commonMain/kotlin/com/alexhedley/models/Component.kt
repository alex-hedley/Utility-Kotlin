package com.alexhedley.models

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

public class Component(
    val id: Int,
    val name: String,
    val description: String,
    val icon: ImageVector,
    val onClick: () -> Unit,
    val view: Unit //@Composable () -> Unit = {}
) {
}