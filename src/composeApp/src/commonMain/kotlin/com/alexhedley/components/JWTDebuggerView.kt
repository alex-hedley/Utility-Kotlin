package com.alexhedley.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp

@Composable
fun JWTDebuggerView() {

    var textErrorValue by remember { mutableStateOf("") }

    MaterialTheme {
        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("JWT Debugger", style = MaterialTheme.typography.titleLarge)
            Text(text = "WIP", color = Color.Red)

            Spacer(modifier = Modifier.size(30.dp))

            Row() {
                Text(textErrorValue, color = Color.Red)
            }

            Spacer(modifier = Modifier.size(30.dp))

            Row() {
                TextField(
                    "HS256",
                    onValueChange = { },
                    placeholder = { "" },
                    label = { Text("Algorithm") },
                    singleLine = true,
                    readOnly = true
                )
            }
            Row() {
                Column() {
                    TextField(
                        "",
                        onValueChange = { },
                        placeholder = { "" },
                        label = { Text("Token") },
                        singleLine = false,
                        minLines = 3,
                        maxLines = 3,
                        modifier = Modifier
//                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(16.dp)
                    )
                }
                Column() {
                    IconButton(
                        onClick = {
                            // TODO
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.DoubleArrow,
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    IconButton(
                        onClick = {
                            // TODO
                        },
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
                Column() {
                    TextField(
                        "",
                        onValueChange = { },
                        placeholder = { "DECODED" },
                        label = { Text("HEADER: ALGORITHM & TOKEN TYPE") },
                        singleLine = false,
                        minLines = 3,
                        maxLines = 3,
                        modifier = Modifier
//                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(16.dp)
                    )
                    TextField(
                        "",
                        onValueChange = { },
                        placeholder = { "DECODED" },
                        label = { Text("PAYLOAD: DATA") },
                        singleLine = false,
                        minLines = 3,
                        maxLines = 3,
                        modifier = Modifier
//                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(16.dp)
                    )
                    TextField(
                        "",
                        onValueChange = { },
                        placeholder = { "DECODED" },
                        label = { Text("VERIFY SIGNATURE") },
                        singleLine = false,
                        minLines = 3,
                        maxLines = 3,
                        modifier = Modifier
//                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(16.dp)
                    )
                }
            }

            Row() {
                Text(
                    buildAnnotatedString {
                        append("Inspired by ")
                        withLink(
                            LinkAnnotation.Url(
                                "https://jwt.io/",
                                TextLinkStyles(SpanStyle(color = Color.Blue))
                            )
                        ) {
                            append("https://jwt.io/")
                        }
                    }
                )
            }
        }

    }
}