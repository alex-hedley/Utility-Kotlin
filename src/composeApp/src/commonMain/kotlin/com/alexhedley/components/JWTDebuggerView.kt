package com.alexhedley.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

internal fun addBase64Padding(s: String): String {
    val padLength = (4 - s.length % 4) % 4
    return s + "=".repeat(padLength)
}

@OptIn(ExperimentalEncodingApi::class)
internal fun decodeBase64Url(s: String): String {
    val padded = addBase64Padding(s.replace('-', '+').replace('_', '/'))
    return Base64.Default.decode(padded).decodeToString()
}

@Composable
fun JWTDebuggerView() {

    var token by remember { mutableStateOf("") }
    var headerDecoded by remember { mutableStateOf("") }
    var payloadDecoded by remember { mutableStateOf("") }
    var signatureRaw by remember { mutableStateOf("") }
    var textErrorValue by remember { mutableStateOf("") }

    Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text("🔑 JWT Debugger", style = MaterialTheme.typography.titleLarge)

            Spacer(modifier = Modifier.size(30.dp))

            Row() {
                Text(textErrorValue, color = Color.Red)
            }

            Spacer(modifier = Modifier.size(30.dp))

            Row() {
                TextField(
                    "HS256",
                    onValueChange = { },
                    placeholder = { },
                    label = { Text("Algorithm") },
                    singleLine = true,
                    readOnly = true
                )
            }
            FlowRow() {
                Column() {
                    TextField(
                        token,
                        onValueChange = { token = it },
                        placeholder = { Text("Paste JWT token here...") },
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
                            try {
                                textErrorValue = ""
                                val parts = token.trim().split(".")
                                require(parts.size == 3) { "Invalid JWT: expected 3 parts separated by '.'" }
                                headerDecoded = decodeBase64Url(parts[0])
                                payloadDecoded = decodeBase64Url(parts[1])
                                signatureRaw = parts[2]
                            } catch (e: Exception) {
                                println("Error: $e")
                                textErrorValue = e.message.toString()
                            }
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
                            token = ""
                            headerDecoded = ""
                            payloadDecoded = ""
                            signatureRaw = ""
                            textErrorValue = ""
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
                        headerDecoded,
                        onValueChange = { },
                        placeholder = { Text("DECODED") },
                        label = { Text("HEADER: ALGORITHM & TOKEN TYPE") },
                        singleLine = false,
                        minLines = 3,
                        maxLines = 3,
                        readOnly = true,
                        modifier = Modifier
//                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(16.dp)
                    )
                    TextField(
                        payloadDecoded,
                        onValueChange = { },
                        placeholder = { Text("DECODED") },
                        label = { Text("PAYLOAD: DATA") },
                        singleLine = false,
                        minLines = 3,
                        maxLines = 3,
                        readOnly = true,
                        modifier = Modifier
//                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(16.dp)
                    )
                    TextField(
                        signatureRaw,
                        onValueChange = { },
                        placeholder = { Text("SIGNATURE") },
                        label = { Text("VERIFY SIGNATURE") },
                        singleLine = false,
                        minLines = 3,
                        maxLines = 3,
                        readOnly = true,
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