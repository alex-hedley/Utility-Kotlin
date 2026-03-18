package com.alexhedley.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
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

internal fun urlEncode(s: String): String = buildString {
    for (c in s) {
        when {
            c.isLetterOrDigit() || c == '-' || c == '_' || c == '.' || c == '~' -> append(c)
            c == ' ' -> append('+')
            else -> {
                for (b in c.toString().encodeToByteArray()) {
                    append('%')
                    append((b.toInt() and 0xFF).toString(16).uppercase().padStart(2, '0'))
                }
            }
        }
    }
}

internal fun urlDecode(s: String): String {
    val bytes = mutableListOf<Byte>()
    var i = 0
    val result = StringBuilder()
    while (i < s.length) {
        when {
            s[i] == '%' && i + 2 < s.length -> {
                bytes.add(s.substring(i + 1, i + 3).toInt(16).toByte())
                i += 3
                // Peek: if the next char is also a percent-encoded byte, keep accumulating
                if (i >= s.length || s[i] != '%') {
                    result.append(bytes.toByteArray().decodeToString())
                    bytes.clear()
                }
            }
            s[i] == '+' -> {
                if (bytes.isNotEmpty()) {
                    result.append(bytes.toByteArray().decodeToString())
                    bytes.clear()
                }
                result.append(' ')
                i++
            }
            else -> {
                if (bytes.isNotEmpty()) {
                    result.append(bytes.toByteArray().decodeToString())
                    bytes.clear()
                }
                result.append(s[i])
                i++
            }
        }
    }
    if (bytes.isNotEmpty()) {
        result.append(bytes.toByteArray().decodeToString())
    }
    return result.toString()
}

@Composable
fun UrlEncodeView() {

    var url by remember { mutableStateOf("") }
    var durl by remember { mutableStateOf("") }

    Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text("🔗 URL Encode/Decode", style = MaterialTheme.typography.titleLarge)

            Spacer(modifier = Modifier.size(30.dp))

            Row()
            {
                Column() {
                    TextField(
                        url,
                        onValueChange = { url = it },
                        placeholder = { Text("https://www.alexhedley.com") },
                        label = { Text("Encode") }
                    )
                }
                Column() {
                    Button(
                        onClick = {
                            durl = urlEncode(url)
                        }
                    ){
                        Text("Encode")
                    }
                }
            }

            Row()
            {
                Column() {
                    TextField(
                        durl,
                        onValueChange = { durl = it },
                        placeholder = { Text("http%3A%2F%2Fwww.alexhedley.com") },
                        label = { Text("Decode") }
                    )
                }
                Column() {
                    Button(
                        onClick = {
                            url = urlDecode(durl)
                        }
                    ){
                        Text("Decode")
                    }
                }
            }

            Spacer(modifier = Modifier.size(30.dp))

            Text(
                buildAnnotatedString {
                    append("Inspired from ")
                    withLink(
                        LinkAnnotation.Url(
                            "https://meyerweb.com/eric/tools/dencoder/",
                            TextLinkStyles(SpanStyle(color = Color.Blue))
                        )
                    ) {
                        append("https://meyerweb.com/eric/tools/dencoder/")
                    }
                    append(" - meyerweb URL Decoder/Encoder")
                }
            )
        }
}