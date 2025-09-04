package net.tactware.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

/**
 * Tab item component.
 */
@Composable
fun TabItem(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val color =
        if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)

    Box(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = text,
            color = color,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
        )
    }
}