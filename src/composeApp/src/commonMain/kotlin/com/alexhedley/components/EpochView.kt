package com.alexhedley.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Recycling
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
fun EpochView() {
    var input by remember { mutableStateOf("") }

    var textErrorValue by remember { mutableStateOf("") }

    MaterialTheme {
        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("Epoch Converter", style = MaterialTheme.typography.titleLarge)
            Text(text = "WIP", color = Color.Red)

            Spacer(modifier = Modifier.size(30.dp))

            Row() {
                Text(textErrorValue, color = Color.Red)
            }

            Spacer(modifier = Modifier.size(30.dp))

            Row() {
                Column() {
                    TextField(
                        input,
//                        modifier = Modifier.fillMaxWidth(),
                        onValueChange = { input = it },
                        placeholder = { "Type in the binary value you wish to convert..." },
                        label = { Text("Timestamps in seconds:") },
    //                    keyboardActions = KeyboardActions.Default.copy(keyboardType = KeyboardType.Number),
                    )
                }
                Column() {
                    IconButton(
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
                        Icon(
                            imageVector = Icons.Default.Recycling,
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
                Column() {
                    Button(
                        onClick = {
                            // TODO
                            // Convert from timestamp in seconds to readable date time
                        },
                        enabled = false
                    ){
                        Text("Convert")
                    }
                }
            }

            Row() {
                Text("GMT:")
            }

            Row() {
                Text("Your time zone:")
            }

            HorizontalDivider()

            Text("TODO: Datetime to EPOCH.", color = Color.Red)
        }
    }
}