package com.alexhedley.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CopyAll
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
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
fun StringConverterView() {
    var input by remember { mutableStateOf("") }
    var output by remember { mutableStateOf("") }

    val options = listOf(
        "Sentence case",
        "lower case",
        "UPPER CASE",
        "Capitalized Case",
        "aLtErNaTiNg cAsE",
        "Title Case",
        "InVeRsE CaSe",
    )
    var selectedOption by remember { mutableStateOf(options[0]) }

    var textErrorValue by remember { mutableStateOf("") }

    MaterialTheme {
        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("String Converter", style = MaterialTheme.typography.titleLarge)
            Text(text = "WIP", color = Color.Red)

            Spacer(modifier = Modifier.size(30.dp))

            Row() {
                Text(textErrorValue, color = Color.Red)
            }

            Spacer(modifier = Modifier.size(30.dp))

            // Option
            Row() {
                Text("Select an Item:", style = MaterialTheme.typography.headlineMedium)
                options.forEach { option ->
                    RadioButton(
                        selected = (option == selectedOption),
                        onClick = { selectedOption = option },
                        colors = RadioButtonDefaults.colors(

                            selectedColor = Color(0xff00BFA5),
                            unselectedColor = Color.Gray,
                            disabledSelectedColor = Color.LightGray,
                            disabledUnselectedColor = Color.LightGray
                        ),
                        modifier = Modifier
                            .size(32.dp)
                            .padding(4.dp),
//                        interactionSource = interactionSource
                    )
                    Text(
                        text = option,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .padding(start = 8.dp)
                    )
                }
            }

            Row() {
                Column() {
                    Text(text = "Selected Item: $selectedOption")
                }
            }

            // Input
            Row() {
                Column() {
                    TextField(
                        input,
                        onValueChange = { input = it },
                        placeholder = { "Type in the string you wish to trim..." },
                        label = { Text("Input") },
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

            Row() {
                Column() {
                    Button(
                        onClick = {

                            // TODO

                        },
                        enabled = false
                    ){
                        Text("Convert")
                    }
                }
            }

            // Output
            Row() {
                Column() {
                    TextField(
                        output,
                        onValueChange = { output = it },
                        placeholder = { "Type in the string with whitespace removed" },
                        label = { Text("Output") },
                        singleLine = false,
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