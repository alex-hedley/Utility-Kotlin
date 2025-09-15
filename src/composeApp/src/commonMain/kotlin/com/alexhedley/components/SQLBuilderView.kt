package com.alexhedley.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SQLBuilderView() {
    Column(
        modifier = Modifier
            .safeContentPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row() {
            Text("SQL Builder", style = MaterialTheme.typography.titleLarge)
        }

//        Spacer(modifier = Modifier.size(10.dp))

//        Row() {
//            SQLINClause()
//        }

//        Spacer(modifier = Modifier.size(10.dp))

        Row() {
            SQLLikeView()
        }

//        Spacer(modifier = Modifier.size(10.dp))

//        Row() {
//
//        }
    }
}