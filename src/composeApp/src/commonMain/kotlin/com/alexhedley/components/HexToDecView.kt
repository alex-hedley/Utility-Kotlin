package com.alexhedley.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CopyAll
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.DoubleArrow
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalUnsignedTypes::class)
@Composable
fun HexToDecView() {
    var hex by remember { mutableStateOf("12") }
    var dec by remember { mutableStateOf("") }

    var textErrorValue by remember { mutableStateOf("") }

    MaterialTheme {
        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("HEX to DEC", style = MaterialTheme.typography.titleLarge)

            Spacer(modifier = Modifier.size(30.dp))

            Row() {
                Text(textErrorValue, color = Color.Red)
            }

            Spacer(modifier = Modifier.size(30.dp))

            // Input
            Row() {
                Column() {
                    TextField(
                        hex,
                        onValueChange = { hex = it },
                        placeholder = { "Type in the value you wish to convert..." },
                        label = { Text("HEX") },
                        singleLine = false,
                    )
                }
                Column() {
                    IconButton(
                        onClick = {
                            try {
                                textErrorValue = ""
                                dec = hex.toLong(16).toString() // BigInteger(hex, 16)
                            } catch (e:Exception) {
                                println("Error: $e")
                                textErrorValue = e.message.toString()
                            }
                        },
                    ) {
                        Icon(
                            imageVector = Icons.Default.DoubleArrow,
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
                        onClick = { hex = "" },
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

            // Output
            Row() {
                Column() {
                    TextField(
                        dec,
                        onValueChange = { dec = it },
                        placeholder = { "Type in the value you wish to convert..." },
                        label = { Text("Dec") },
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                    )
                }
                Column() {
                    IconButton(
                        onClick = {
                            try {
                                textErrorValue = ""
                                hex = dec.toByte().toHexString()
                            } catch (e:Exception) {
                                println("Error: $e")
                                textErrorValue = e.message.toString()
                            }
                        },
                    ) {
                        Icon(
                            imageVector = Icons.Default.DoubleArrow,
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
                        onClick = { dec = "" },
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