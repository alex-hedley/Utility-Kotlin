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
import androidx.compose.ui.platform.LocalClipboard
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
@Composable
fun GuidView() {
    val clipboard = LocalClipboard.current
    var guid by remember { mutableStateOf("") }
    guid = Uuid.random().toString()

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
                Column() {
                    TextField(
                        guid,
                        onValueChange = { guid = it },
                        placeholder = { Text("00000000-0000-0000-0000-000000000000") },
                        label = { Text("New") }
                    )
                }
                Column() {
                    Button(
                        onClick = {
//                            clipboard.setText(AnnotatedString((guid)))
//                            clipboard.getText()?.text?.let {
//                                guid = it
//                            }
                        }
                    ){
                        Text("Copy")
                    }
                }
            }
        }


    }
}