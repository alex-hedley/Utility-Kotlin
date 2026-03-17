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
import androidx.compose.material.icons.filled.KeyboardDoubleArrowDown
import androidx.compose.material.icons.filled.KeyboardDoubleArrowUp
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

internal fun binaryToText(input: String): String = input.trim()
    .split(Regex("\\s+"))
    .filter { it.isNotBlank() }
    .map { it.toInt(2).toChar() }
    .joinToString("")

internal fun textToBinary(input: String): String = input.map { char ->
    char.code.toString(2).padStart(8, '0')
}.joinToString(" ")

@Composable
fun BinaryView() {
    val defaultValue = "01101111 01101110 01100101 00100000 01101100 01101001 01101110 01100101";
    var input by remember { mutableStateOf(defaultValue) }
    var output by remember { mutableStateOf("") }

    var textErrorValue by remember { mutableStateOf("") }

    MaterialTheme {
        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("Binary", style = MaterialTheme.typography.titleLarge)

            Spacer(modifier = Modifier.size(30.dp))

            Row() {
                Text(textErrorValue, color = Color.Red)
            }

            Spacer(modifier = Modifier.size(30.dp))

            // Input (Binary)
            Row() {
                Column() {
                    TextField(
                        input,
                        onValueChange = { input = it },
                        placeholder = { "Type in the binary value you wish to convert..." },
//                        label = { Text("Binary") },
                        singleLine = false,
                    )
                }
                Column() {
                    IconButton(
                        onClick = {
                            try {
                                textErrorValue = ""
                                output = binaryToText(input)
                            } catch (e:Exception) {
                                println("Error: $e")
                                textErrorValue = e.message.toString()
                            }
                        },
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardDoubleArrowDown,
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    }
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

            // Output (Text)
            Row() {
                Column() {
                    TextField(
                        output,
                        onValueChange = { output = it },
                        placeholder = { "Type in the value you wish to convert to binary..." },
//                        label = { Text("String") },
                        singleLine = false,
                    )
                }
                Column() {
                    IconButton(
                        onClick = {
                            try {
                                textErrorValue = ""
                                input = textToBinary(output)
                            } catch (e:Exception) {
                                println("Error: $e")
                                textErrorValue = e.message.toString()
                            }
                        },
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardDoubleArrowUp,
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    }
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
                Column() {
                    IconButton(
                        onClick = { output = "" },
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
        }
    }
}