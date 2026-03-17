package com.alexhedley.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CopyAll
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

internal fun luhnCheck(input: String): String {
    val digits = input.filter { it.isDigit() }
    if (digits.isEmpty()) return "Invalid: no digits found"
    var sum = 0
    var isEven = false
    for (i in digits.indices.reversed()) {
        var digit = digits[i] - '0'
        if (isEven) {
            digit *= 2
            if (digit > 9) digit -= 9
        }
        sum += digit
        isEven = !isEven
    }
    return if (sum % 10 == 0) "Valid" else "Invalid"
}

@Composable
fun LuhnChecker() {
    val defaultValue = "";
    var input by remember { mutableStateOf(defaultValue) }
    var output by remember { mutableStateOf("") }

    var textErrorValue by remember { mutableStateOf("") }

    Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text("🏦 Luhn Checker", style = MaterialTheme.typography.titleLarge)

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
                        placeholder = { "" },
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
                            output = luhnCheck(input)
                        },
                        enabled = true
                    ){
                        Text("Check")
                    }
                }
            }

            // Output
            Row() {
                Column() {
                    TextField(
                        output,
                        onValueChange = { output = it },
                        placeholder = { "Output" },
                        label = { Text("") },
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