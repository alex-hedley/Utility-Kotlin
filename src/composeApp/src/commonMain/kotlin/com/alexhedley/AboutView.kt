package com.alexhedley

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun AboutView(onDismiss: () -> Unit) {
    MaterialTheme {
        ->
        AlertDialog(
            icon = {
                Icon(imageVector = Icons.Default.Info, contentDescription = "Icon")
            },
            title = {
                Text(text = "About")
            },
            text = {
                Column(
                    modifier = Modifier.safeContentPadding(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text("Utility Kotlin", style = MaterialTheme.typography.titleMedium)
                    Text("")
                    Text("A collection of helpful utilities to make your day easier.")
                    Text("Created by Alex Hedley")
                    Text("")
                    Text("See https://www.alexhedley.com/")
                    Text("© 2025")
                    Text("")
                    HorizontalDivider()
                    Text("")
                    Text("See https://github.com/alex-hedley/Utility-Kotlin")
                    Text("See https://alex-hedley.github.io/Utility-Kotlin/")
                }
            },
            onDismissRequest = onDismiss,
            confirmButton = {
                Text(
                    "OK",
                    modifier = Modifier.clickable { onDismiss() }
                )
            }
        )
    }
}