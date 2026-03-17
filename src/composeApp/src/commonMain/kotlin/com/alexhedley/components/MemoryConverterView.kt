package com.alexhedley.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
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
import kotlin.math.round

internal fun formatBytes(bytes: Double, divisor: Double): String {
    val value = bytes / divisor
    val rounded = round(value * 10000.0) / 10000.0
    return rounded.toString()
}

@Composable
fun MemoryConverterView() {
    val defaultValue = "1030";
    var input by remember { mutableStateOf(defaultValue) }
    var kb by remember { mutableStateOf("") }
    var mb by remember { mutableStateOf("") }
    var gb by remember { mutableStateOf("") }
    var tb by remember { mutableStateOf("") }

    var textErrorValue by remember { mutableStateOf("") }

    MaterialTheme {
        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("Memory Converter", style = MaterialTheme.typography.titleLarge)

            Spacer(modifier = Modifier.size(30.dp))

            Row() {
                Text(textErrorValue, color = Color.Red)
            }

            Spacer(modifier = Modifier.size(30.dp))

            Row() {
                Column() {
                    TextField(
                        input,
                        onValueChange = { input = it },
                        placeholder = { "Type in the memory amount in bytes..." },
                        label = { Text("Bytes") },
                        singleLine = true,
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

            Row() {
                Column() {
                    Button(
                        onClick = {
                            try {
                                textErrorValue = ""
                                val bytes = input.trim().toDouble()
                                kb = formatBytes(bytes, 1024.0)
                                mb = formatBytes(bytes, 1024.0 * 1024.0)
                                gb = formatBytes(bytes, 1024.0 * 1024.0 * 1024.0)
                                tb = formatBytes(bytes, 1024.0 * 1024.0 * 1024.0 * 1024.0)
                            } catch (e: Exception) {
                                println("Error: $e")
                                textErrorValue = e.message.toString()
                            }
                        },
                        enabled = true
                    ){
                        Text("Convert")
                    }
                }
            }

            // Output
            Row() {
                Column() {
                    TextField(
                        kb,
                        onValueChange = { },
                        label = { Text("Kilobytes (KB)") },
                        singleLine = true,
                        readOnly = true,
                    )
                }
            }
            Row() {
                Column() {
                    TextField(
                        mb,
                        onValueChange = { },
                        label = { Text("Megabytes (MB)") },
                        singleLine = true,
                        readOnly = true,
                    )
                }
            }
            Row() {
                Column() {
                    TextField(
                        gb,
                        onValueChange = { },
                        label = { Text("Gigabytes (GB)") },
                        singleLine = true,
                        readOnly = true,
                    )
                }
            }
            Row() {
                Column() {
                    TextField(
                        tb,
                        onValueChange = { },
                        label = { Text("Terabytes (TB)") },
                        singleLine = true,
                        readOnly = true,
                    )
                }
            }
        }
    }
}