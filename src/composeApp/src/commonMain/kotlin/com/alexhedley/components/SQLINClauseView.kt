package com.alexhedley.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CopyAll
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SQLINClauseView() {
    var input by remember { mutableStateOf("") }
    var output by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    var textErrorValue by remember { mutableStateOf("") }

    MaterialTheme {
        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("IN Clause", style = MaterialTheme.typography.titleLarge)
            Text(text = "WIP", color = Color.Red)

            Spacer(modifier = Modifier.size(30.dp))

            Row() {
                Text(textErrorValue, color = Color.Red)
            }

            Spacer(modifier = Modifier.size(30.dp))

            // Input
            Row() {
                Column() {
                    TextField(
                        input,
                        onValueChange = { input = it },
                        placeholder = { "Type in the sql items you wish to convert" },
                        label = { Text("SQL") },
                        singleLine = false,
                    )
                }
                Column() {
                    IconButton(
                        onClick = { input = "" },
                        colors = IconButtonDefaults.iconButtonColors(
                            contentColor = Color.White,
                            containerColor = Color.Red
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }

            // Wrapper
            Row() {
                Column() {
                    Text(text = "Wrapper:")
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                    ) {
                        DropdownMenuItem(
                            text = { Text("'") },
                            onClick = {}
                        )
                    }
                }
                Column() {
                    Button(
                        onClick = {},
                        enabled = false
                    ){
                        Text("Parse")
                    }
                }
            }

            // Remove Duplicates
            Row() {
                Checkbox(
                    checked = false,
                    onCheckedChange = {},
                )
                Text(text = "Remove Duplicates")
            }

            // Output
            Row() {
                Column() {
                    TextField(
                        output,
                        onValueChange = { output = it },
                        placeholder = { "" },
                        label = { Text("") },
                        singleLine = false,
                        readOnly = true
                    )
                }
                Column() {
                    IconButton(
                        onClick = {  },
                        enabled = false,
                    ) {
                        Icon(
                            imageVector = Icons.Default.CopyAll,
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }

        }
    }
}