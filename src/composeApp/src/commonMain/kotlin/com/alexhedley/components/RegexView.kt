package com.alexhedley.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CopyAll
import androidx.compose.material3.Button
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.ui.platform.LocalClipboard
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp

@Composable
fun RegexView() {
    val defaultValue = "\\d{1,5}";
    var regularExpression by remember { mutableStateOf(defaultValue) }
    var count by remember { mutableStateOf("5") }
    var output by remember { mutableStateOf("") }

    val clipboard = LocalClipboard.current
    val coroutineScope = rememberCoroutineScope()

    var textErrorValue by remember { mutableStateOf("") }

    Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text("🔎 Regex", style = MaterialTheme.typography.titleLarge)
            Text(text = "WIP", color = Color.Red)

            Spacer(modifier = Modifier.size(30.dp))

            Row() {
                Text(textErrorValue, color = Color.Red)
            }

            Spacer(modifier = Modifier.size(30.dp))

            Row() {
                Column() {
                    TextField(
                        regularExpression,
                        onValueChange = { regularExpression = it },
                        placeholder = { "A regex to use" },
                        label = { Text("Regular Expression") },
                    )
                }
                Spacer(modifier = Modifier.size(10.dp))
                Column() {
                    TextField(
                        count,
                        onValueChange = { count = it },
                        placeholder = { "A regex to use" },
                        label = { Text("Regular Expression") },
                    )
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
                        Text("Generate")
                    }
                }
            }

            // Output
            Row() {
                Column() {
                    TextField(
                        output,
                        onValueChange = { output = it },
                        placeholder = { "" },
                        label = { Text("Output") },
                        singleLine = false,
//                        modifier = Modifier.fillMaxSize(),
                    )
                }
                Column() {
                    IconButton(
                        onClick = { coroutineScope.launch { clipboard.setClipEntry(output.toClipEntry()) } },
                    ) {
                        Icon(
                            imageVector = Icons.Default.CopyAll,
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.size(30.dp))

            Text(
                buildAnnotatedString {
                    append("Inspired from String from Regex Generator - ")
                    withLink(
                        LinkAnnotation.Url(
                            "https://onlinestringtools.com/generate-string-from-regex",
                            TextLinkStyles(SpanStyle(color = Color.Blue))
                        )
                    ) {
                        append("https://onlinestringtools.com/generate-string-from-regex")
                    }
                }
            )
        }
}