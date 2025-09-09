package com.alexhedley.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
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
import androidx.compose.ui.unit.dp

//import java.net.URLEncoder
//import java.net.URLDecoder

@Composable
fun UrlEncodeView() {

    var url by remember { mutableStateOf("") }
    var durl by remember { mutableStateOf("") }

    MaterialTheme {
        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("URL Encode/Decode", style = MaterialTheme.typography.titleLarge)

            Text(text = "WIP", color = Color.Red)
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
//                    durl = URLEncoder.encode(url, "utf-8")
                            durl = "<Encoded>"
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
//                    url = URLDecoder.decode(durl, "utf-8")
                            url = "<Decoded>"
                        }
                    ){
                        Text("Decode")
                    }
                }
            }

            Spacer(modifier = Modifier.size(30.dp))

//            Text("Inspired from <a href=\"https://meyerweb.com/eric/tools/dencoder/\" target=\"_blank\">meyerweb URL Decoder/Encoder</a>")
            Text("Inspired from https://meyerweb.com/eric/tools/dencoder/ - meyerweb URL Decoder/Encoder")
        }
    }
}