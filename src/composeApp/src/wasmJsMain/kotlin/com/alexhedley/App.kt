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
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.painterResource

import kotlin.time.Duration;

import utility_kotlin.composeapp.generated.resources.Res
import utility_kotlin.composeapp.generated.resources.compose_multiplatform

@Composable
fun App() {
    MaterialTheme {
        var durationText by remember { mutableStateOf("PT10M14.230852287S") }

        var textFieldDaysValue by remember { mutableStateOf("") }
        var textFieldHoursValue by remember { mutableStateOf("") }
        var textFieldMinutesValue by remember { mutableStateOf("") }
        var textFieldMillisValue by remember { mutableStateOf("") }
        var textFieldNanosValue by remember { mutableStateOf("") }
        var textFieldSecondsValue by remember { mutableStateOf("") }

        var textErrorValue by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Text("Java / Kotlin Duration parser:", style = MaterialTheme.typography.titleLarge)

            Text("Example: PT10M14.230852287S")

            // Duration input field
            TextField(
                durationText,
                onValueChange = { durationText = it },
                placeholder = { Text("Duration") },
                label = { Text("Duration") }
            )

            Text(textErrorValue, color = Color.Red)

            Button(onClick = {
                println("Duration: '$durationText'")
//                val duration = DurationParser().parse(durationText)
                try {
                    val duration = Duration.parse(durationText);

                    println("Days       : " + duration.inWholeDays)
                    textFieldDaysValue = duration.inWholeDays.toString()
                    println("Hours      : " + duration.inWholeHours)
                    textFieldHoursValue = duration.inWholeHours.toString()
                    println("Minutes    : " + duration.inWholeMinutes)
                    textFieldMinutesValue = duration.inWholeMinutes.toString()
                    println("Seconds    : " + duration.inWholeSeconds)
                    textFieldSecondsValue = duration.inWholeSeconds.toString()
                    println("Millis     : " + duration.inWholeMilliseconds)
                    textFieldMillisValue = duration.inWholeMilliseconds.toString()
                    println("Nanos      : " + duration.inWholeNanoseconds)
                    textFieldNanosValue = duration.inWholeNanoseconds.toString()

                    textErrorValue = ""
                }
                catch (e:Exception) {
                    println("Error: $e")
                    textErrorValue = e.message.toString()
                }

            }) {
                Text("Convert")
            }

            TextField(textFieldDaysValue,
                onValueChange = { textFieldDaysValue = it },
                placeholder = { Text("Days") },
                label = { Text("Days") }
            )

            TextField(textFieldHoursValue,
                onValueChange = { textFieldHoursValue = it },
                placeholder = { Text("Hours") },
                label = { Text("Hours") }
            )

            TextField(textFieldMinutesValue,
                onValueChange = { textFieldMinutesValue = it },
                placeholder = { Text("Minutes") },
                label = { Text("Minutes") }
            )

            TextField(textFieldSecondsValue,
                onValueChange = { textFieldSecondsValue = it },
                placeholder = { Text("Seconds") },
                label = { Text("Seconds") }
            )

            TextField(textFieldMillisValue,
                onValueChange = { textFieldMillisValue = it },
                placeholder = { Text("Millis") },
                label = { Text("Millis") }
            )

            TextField(textFieldNanosValue,
                onValueChange = { textFieldNanosValue = it },
                placeholder = { Text("Nanos") },
                label = { Text("Nanos") }
            )

        }
    }
}