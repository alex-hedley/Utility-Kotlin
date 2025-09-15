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
fun SQLLikeView() {
    var field by remember { mutableStateOf("") }
    var input by remember { mutableStateOf("") }
    var output by remember { mutableStateOf("") }

    var textErrorValue by remember { mutableStateOf("") }

    MaterialTheme {
        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("LIKE Clause", style = MaterialTheme.typography.titleLarge)
            Text(text = "WIP", color = Color.Red)

            Spacer(modifier = Modifier.size(30.dp))

            Row() {
                Text(textErrorValue, color = Color.Red)
            }

            Spacer(modifier = Modifier.size(30.dp))

            // Field
            Row() {
                Column() {
                    TextField(
                        field,
                        onValueChange = { field = it },
                        placeholder = { "FirstName" },
                        label = { Text("Field") },
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
                Column() {
                    IconButton(
                        onClick = { field = "" },
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

            // Input
            Row() {
                Column() {
                    TextField(
                        input,
                        onValueChange = { input = it },
                        placeholder = { "Alex" },
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

            // Parse
            Row() {
                Column() {
                    Button(
                        onClick = {

                            // TODO

                        },
                        enabled = false
                    ){
                        Text("Parse")
                    }
                }
            }

            Row() {
                Column() {
                    TextField(
                        output,
                        onValueChange = { output = it },
                        placeholder = { "FirstName LIKE %Alex%" },
                        label = { Text("Input") },
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