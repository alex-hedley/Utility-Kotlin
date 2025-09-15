package com.alexhedley.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
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
fun HexToRgbView() {
    var input by remember { mutableStateOf("#ff6a00") }
    var red by remember { mutableStateOf("0") }
    var green by remember { mutableStateOf("0") }
    var blue by remember { mutableStateOf("0") }

    var textErrorValue by remember { mutableStateOf("") }

    MaterialTheme {
        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("HEX to RGB", style = MaterialTheme.typography.titleLarge)
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
                        placeholder = { "Type in the colour HEX code you wish to convert..." },
                        label = { Text("Encode") },
                        singleLine = false,
                    )
                }
                Column() {
                    Button(
                        onClick = {
                            try {
                                textErrorValue = ""

                                // TODO

                            } catch (e:Exception) {
                                println("Error: $e")
                                textErrorValue = e.message.toString()
                            }
                        },
                    ) {
                        Text("Convert")
                    }
                }

            }

            // Output
            Row() {
                Column() {
                    TextField(
                        red,
                        onValueChange = { red = it },
                        placeholder = { "Red" },
                        label = { Text("Red") },
                        readOnly = true,
                    )
                }
                Column() {
                    TextField(
                        green,
                        onValueChange = { green = it },
                        placeholder = { "Green" },
                        label = { Text("Green") },
                        readOnly = true,
                    )
                }
                Column() {
                    TextField(
                        blue,
                        onValueChange = { blue = it },
                        placeholder = { "Blue" },
                        label = { Text("Blue") },
                        readOnly = true,
                    )
                }
            }
        }
    }

}