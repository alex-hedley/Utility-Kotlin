package com.alexhedley

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.alexhedley.models.Component

@Composable
fun ComponentsView(components: List<Component>) {
    MaterialTheme {
        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                "Components",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(top = 16.dp)
            )

            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 128.dp),
                contentPadding = PaddingValues(100.dp)
            ) {
                items(components.size) { idx ->
                    val component = components[idx];

//                    Surface(
//                        color = MaterialTheme.colorScheme.surface,
//                        shape = RoundedCornerShape(4.dp),
//                        modifier = Modifier.fillMaxWidth()
//                    ) {
//                    Box(modifier = Modifier, contentAlignment = Alignment.Center) {
                    Card(
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), // contentColorFor()
                        modifier = Modifier
                            .clickable(onClick = component.onClick)
                            .padding(4.dp)
//                            .fillMaxWidth()
//                            .fillMaxHeight()
                        ,
                        elevation =  CardDefaults.cardElevation(defaultElevation = 8.dp),
                    ) {
                        Row(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(10.dp),
                        ) {
                            Icon(
                                imageVector = component.icon,
                                contentDescription = component.description,

                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(
                            Modifier.padding(start = 12.dp, end = 12.dp)
                        ) {
                            Text(component.name, textAlign = TextAlign.Center)
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                }
            }
        }
    }
}