package com.alexhedley

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.alexhedley.components.AsciiView
import com.alexhedley.components.Base64View
import com.alexhedley.components.BinaryView
import com.alexhedley.components.DurationParserView
import com.alexhedley.components.EpochView
import com.alexhedley.components.GuidView
import com.alexhedley.components.HexToDecView
import com.alexhedley.components.HTMLEncodeDecode
import com.alexhedley.components.HexToRgbView
import com.alexhedley.components.JWTDebuggerView
import com.alexhedley.components.LuhnChecker
import com.alexhedley.components.MD5View
import com.alexhedley.components.MemoryConverterView
import com.alexhedley.components.RegexView
import com.alexhedley.components.RemoveWhitespaceView
import com.alexhedley.components.SQLContainsView
import com.alexhedley.components.SQLINClauseView
import com.alexhedley.components.SQLLikeView
import com.alexhedley.components.StringConverterView
import com.alexhedley.components.TimeConverterView
import com.alexhedley.components.UnicodeView
import com.alexhedley.components.UrlEncodeView

@Composable
fun AllToolsView() {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(3),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalItemSpacing = 16.dp,
    ) {
        item { ToolCard { RemoveWhitespaceView() } }
        item { ToolCard { StringConverterView() } }
        item { ToolCard { HexToRgbView() } }
        item { ToolCard { HTMLEncodeDecode() } }
        item { ToolCard { MemoryConverterView() } }
        item { ToolCard { TimeConverterView() } }
        item { ToolCard { LuhnChecker() } }
        item { ToolCard { BinaryView() } }
        item { ToolCard { SQLLikeView() } }
        item { ToolCard { SQLContainsView() } }
        item { ToolCard { SQLINClauseView() } }
        item { ToolCard { JWTDebuggerView() } }
        item { ToolCard { EpochView() } }
        item { ToolCard { MD5View() } }
        item { ToolCard { AsciiView() } }
        item { ToolCard { UrlEncodeView() } }
        item { ToolCard { Base64View() } }
        item { ToolCard { GuidView() } }
        item { ToolCard { HexToDecView() } }
        item { ToolCard { DurationParserView() } }
        item { ToolCard { UnicodeView() } }
        item { ToolCard { RegexView() } }
    }
}

@Composable
private fun ToolCard(content: @Composable () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        content()
    }
}
