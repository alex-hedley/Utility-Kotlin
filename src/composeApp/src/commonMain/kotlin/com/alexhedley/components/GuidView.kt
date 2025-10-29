package com.alexhedley.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CopyAll
import androidx.compose.material.icons.filled.Recycling
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
import androidx.compose.ui.platform.LocalClipboard
import androidx.compose.ui.unit.dp
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
@Composable
fun GuidView() {
    val clipboard = LocalClipboard.current
    var guid by remember { mutableStateOf("") }
    guid = Uuid.random().toString()
    var guidZero by remember { mutableStateOf("00000000-0000-0000-0000-000000000000") }

    var textErrorValue by remember { mutableStateOf("") }

    MaterialTheme {
        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("Guids", style = MaterialTheme.typography.titleLarge)

            Text(text = "WIP", color = Color.Red)
            Spacer(modifier = Modifier.size(30.dp))

            Row() {
                Text(textErrorValue, color = Color.Red)
            }

            Spacer(modifier = Modifier.size(30.dp))

            Row() {
                Column() {
                    TextField(
                        guidZero,
                        onValueChange = { },
                        placeholder = { Text(guidZero) },
                        label = { Text("Zero") },
                        readOnly = true
                    )
                }
                Column() {
                    IconButton(
                        onClick = {
                            // https://youtrack.jetbrains.com/issue/CMP-7624
//                            clipboard.setText(AnnotatedString((guid)))
//                            clipboard.getText()?.text?.let {
//                                guid = it
//                            }
                        },
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

            Row() {
                Column() {
                    TextField(
                        guid,
                        onValueChange = { guid = it },
                        placeholder = { Text(guidZero) },
                        label = { Text("New") }
                    )
                }
                IconButton(
                    onClick = {
                        try {
                            textErrorValue = ""
                            guid = Uuid.random().toString()
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
                Column() {
                    IconButton(
                        onClick = {
                            // https://youtrack.jetbrains.com/issue/CMP-7624
//                            clipboard.setText(AnnotatedString((guid)))
//                            clipboard.getText()?.text?.let {
//                                guid = it
//                            }
                        },
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