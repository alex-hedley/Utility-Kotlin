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
import androidx.compose.material.icons.filled.DoubleArrow
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp
import kotlin.io.encoding.Base64

@Composable
fun Base64View() {
    var input by remember { mutableStateOf("QWxleEhlZGxleQ==") }
    var output by remember { mutableStateOf("") }

    var textErrorValue by remember { mutableStateOf("") }

    MaterialTheme {
        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("Base64", style = MaterialTheme.typography.titleLarge)

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
                        placeholder = { "Type in the value you wish to convert..." },
                        label = { Text("Base64") },
                        singleLine = false,
                    )
                }
                Column() {
                    IconButton(
                        onClick = {
                            try {
                                textErrorValue = ""
                                output = Base64.Default.decode(input).decodeToString()
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

            // Output
            Row() {
                Column() {
                    TextField(
                        output,
                        onValueChange = { output = it },
                        placeholder = { "Type in the value you wish to convert..." },
                        label = { Text("String") },
                        singleLine = false,
                    )
                }
                Column() {
                    IconButton(
                        onClick = {
                            try {
                                textErrorValue = ""
                                input = Base64.Default.encode(output.encodeToByteArray())
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

            Spacer(modifier = Modifier.size(30.dp))

            Text(
                buildAnnotatedString {
                    append("Inspired from ")
                    withLink(
                        LinkAnnotation.Url(
                            "https://www.base64encode.org/",
                            TextLinkStyles(SpanStyle(color = Color.Blue))
                        )
                    ) {
                        append("https://www.base64encode.org/")
                    }
                    append(" - base64encode")
                }
            )

            Text(
                buildAnnotatedString {
                    append("Inspired from ")
                    withLink(
                        LinkAnnotation.Url(
                            "https://www.base64decode.org/",
                            TextLinkStyles(SpanStyle(color = Color.Blue))
                        )
                    ) {
                        append("https://www.base64decode.org/")
                    }
                    append(" - base64decode")
                }
            )
        }
    }
}