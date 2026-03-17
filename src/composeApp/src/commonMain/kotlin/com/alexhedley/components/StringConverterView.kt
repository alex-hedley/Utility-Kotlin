package com.alexhedley.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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

internal fun convertString(input: String, option: String): String = when (option) {
    "Sentence case" -> input.lowercase().replaceFirstChar { it.uppercaseChar() }
    "lower case" -> input.lowercase()
    "UPPER CASE" -> input.uppercase()
    "Capitalized Case" -> input.split(" ").joinToString(" ") { word ->
        word.lowercase().replaceFirstChar { it.uppercaseChar() }
    }
    "aLtErNaTiNg cAsE" -> input.mapIndexed { index, c ->
        if (index % 2 == 0) c.lowercaseChar() else c.uppercaseChar()
    }.joinToString("")
    "Title Case" -> input.split(" ").joinToString(" ") { word ->
        word.lowercase().replaceFirstChar { it.uppercaseChar() }
    }
    "InVeRsE CaSe" -> input.map { c ->
        if (c.isUpperCase()) c.lowercaseChar() else c.uppercaseChar()
    }.joinToString("")
    else -> input
}

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

    Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text("📝 String Converter", style = MaterialTheme.typography.titleLarge)

            Spacer(modifier = Modifier.size(30.dp))

            Row() {
                Text(textErrorValue, color = Color.Red)
            }

            Spacer(modifier = Modifier.size(30.dp))

            // Option
            Row() {
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
                            output = convertString(input, selectedOption)
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