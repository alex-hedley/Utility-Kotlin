package com.alexhedley.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Recycling
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.unit.dp

internal fun isLeapYear(year: Int): Boolean =
    (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)

internal fun epochToUtcString(epochSeconds: Long): String {
    var remaining = epochSeconds
    val seconds = (remaining % 60).toInt()
    remaining /= 60
    val minutes = (remaining % 60).toInt()
    remaining /= 60
    val hours = (remaining % 24).toInt()
    var days = remaining / 24

    var year = 1970
    while (true) {
        val daysInYear = if (isLeapYear(year)) 366L else 365L
        if (days < daysInYear) break
        days -= daysInYear
        year++
    }

    val monthDays = if (isLeapYear(year))
        intArrayOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    else
        intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

    var month = 1
    for (m in monthDays) {
        if (days < m) break
        days -= m
        month++
    }
    val day = (days + 1).toInt()

    fun pad(n: Int) = n.toString().padStart(2, '0')
    return "$year-${pad(month)}-${pad(day)} ${pad(hours)}:${pad(minutes)}:${pad(seconds)} UTC"
}

@Composable
fun EpochView() {
    var input by remember { mutableStateOf("") }
    var gmtOutput by remember { mutableStateOf("") }

    var textErrorValue by remember { mutableStateOf("") }

    Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text("🕐 Epoch Converter", style = MaterialTheme.typography.titleLarge)

            Spacer(modifier = Modifier.size(30.dp))

            Row() {
                Text(textErrorValue, color = Color.Red)
            }

            Spacer(modifier = Modifier.size(30.dp))

            Row() {
                Column() {
                    TextField(
                        input,
//                        modifier = Modifier.fillMaxWidth(),
                        onValueChange = { input = it },
                        placeholder = { Text("e.g. 1700000000") },
                        label = { Text("Timestamps in seconds:") },
    //                    keyboardActions = KeyboardActions.Default.copy(keyboardType = KeyboardType.Number),
                    )
                }
                Column() {
                    IconButton(
                        onClick = {
                            try {
                                textErrorValue = ""
                                input = currentEpochSeconds().toString()
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
                }
                Column() {
                    Button(
                        onClick = {
                            try {
                                textErrorValue = ""
                                val epoch = input.trim().toLong()
                                gmtOutput = epochToUtcString(epoch)
                            } catch (e: Exception) {
                                println("Error: $e")
                                textErrorValue = e.message.toString()
                            }
                        },
                        enabled = true
                    ){
                        Text("Convert")
                    }
                }
            }

            Row() {
                Text("GMT: $gmtOutput")
            }

            HorizontalDivider()
        }
}