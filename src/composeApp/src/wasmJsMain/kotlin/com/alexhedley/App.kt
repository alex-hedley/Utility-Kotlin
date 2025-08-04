package com.alexhedley

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Label
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource

import utility_kotlin.composeapp.generated.resources.Res
import utility_kotlin.composeapp.generated.resources.compose_multiplatform

@Composable
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        var durationText by remember { mutableStateOf("PT10M14.230852287S") }
        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
            // Label
            Text("PT10M14.230852287S")

            // Duration input field
            TextField(
                "PT10M14.230852287S",
                onValueChange = {
//                    val duration = DurationParser().parse(it)
//                    println(duration)
                    durationText = it
                },
                placeholder = { Text("Duration") }
            )

            Button(onClick = {
                showContent = !showContent
                println("Duration: '$durationText'")
                val duration = DurationParser().parse(durationText)
            }) {
                Text("Click me!")
            }



        }
    }
}