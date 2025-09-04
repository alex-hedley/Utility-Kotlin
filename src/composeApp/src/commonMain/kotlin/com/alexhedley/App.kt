package com.alexhedley

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

//import utility_kotlin.composeapp.generated.resources.Res
//import utility_kotlin.composeapp.generated.resources.compose_multiplatform

@Composable
fun App() {

    MaterialTheme {
        DurationParserView()
    }
}
