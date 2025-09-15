package com.alexhedley

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Abc
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Adjust
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Colorize
import androidx.compose.material.icons.filled.LockClock
import androidx.compose.material.icons.filled.Memory
import androidx.compose.material.icons.filled.PunchClock
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alexhedley.components.AsciiView
import com.alexhedley.components.Base64View
import com.alexhedley.components.BinaryView
import com.alexhedley.components.DurationParserView
import com.alexhedley.components.EpochView
import com.alexhedley.components.GuidView
import com.alexhedley.components.HTMLEncodeDecode
import com.alexhedley.components.HexToRgbView
import com.alexhedley.components.LuhnChecker
import com.alexhedley.components.MD5View
import com.alexhedley.components.MemoryConverterView
import com.alexhedley.components.RemoveWhitespaceView
import com.alexhedley.components.SQLBuilderView
import com.alexhedley.components.StringConverterView
import com.alexhedley.components.TimeConverterView
import com.alexhedley.components.UnicodeView
import com.alexhedley.components.UrlEncodeView

import net.tactware.components.NavRailItem
import net.tactware.composedesktop.scaffold.components.DesktopApplicationScaffold
import net.tactware.composedesktop.scaffold.components.DesktopAreaScaffold
import net.tactware.composedesktop.scaffold.components.DesktopNavigationRail
import net.tactware.composedesktop.scaffold.components.DesktopTopBar
import net.tactware.composedesktop.scaffold.state.rememberNavigationPanelState
import net.tactware.composedesktop.scaffold.state.rememberOptionalPanelState

/**
 * Example implementation of the Desktop Scaffold to test layout options.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp() {
    // State for the navigation panel

    // State for the selected navigation item
    var selectedNavItem by remember { mutableStateOf(0) }

    DesktopApplicationScaffold(
        topBar = {
            DesktopTopBar(
                title = {
                    Text("Utility")
                },
            )
        },

        // Navigation rail implementation
        navigationRail = {
            DesktopNavigationRail(
                header = {
                    IconButton(onClick = { /* Menu action */ }) {
                        Icon(Icons.Default.Add, contentDescription = "Menu")
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                },
                content = {
                    // Duration Parser
                    NavRailItem(
                        icon = Icons.Default.Adjust,
                        isSelected = selectedNavItem == 0,
                        onClick = { selectedNavItem = 0 }
                    )
                    // URL Encode
                    NavRailItem(
                        icon = Icons.Default.Code,
                        isSelected = selectedNavItem == 1,
                        onClick = { selectedNavItem = 1 }
                    )
                    // Guid
                    NavRailItem(
                        icon = Icons.Default.Code,
                        isSelected = selectedNavItem == 2,
                        onClick = { selectedNavItem = 2 }
                    )
                    // Base64
                    NavRailItem(
                        icon = Icons.Default.Abc,
                        isSelected = selectedNavItem == 3,
                        onClick = { selectedNavItem = 3 }
                    )
//                    // ASCII
//                    NavRailItem(
//                        icon = Icons.Default.Abc,
//                        isSelected = selectedNavItem == 5,
//                        onClick = { selectedNavItem = 5 }
//                    )
//                    // HTML Encode / Decode
//                    NavRailItem(
//                        icon = Icons.Default.Abc,
//                        isSelected = selectedNavItem == 6,
//                        onClick = { selectedNavItem = 6 }
//                    )
//                    // HEX to RGB
//                    NavRailItem(
//                        icon = Icons.Default.Colorize,
//                        isSelected = selectedNavItem == 7,
//                        onClick = { selectedNavItem = 7 }
//                    )
//                    // SQL Builder
//                    NavRailItem(
//                        icon = Icons.Default.Code,
//                        isSelected = selectedNavItem == 8,
//                        onClick = { selectedNavItem = 8 }
//                    )
//                    // Remove Whitespace
//                    NavRailItem(
//                        icon = Icons.Default.Abc,
//                        isSelected = selectedNavItem == 9,
//                        onClick = { selectedNavItem = 9 }
//                    )
//                    // String Converter
//                    NavRailItem(
//                        icon = Icons.Default.Abc,
//                        isSelected = selectedNavItem == 10,
//                        onClick = { selectedNavItem = 10 }
//                    )
//                    // Binary
//                    NavRailItem(
//                        icon = Icons.Default.Abc,
//                        isSelected = selectedNavItem == 11,
//                        onClick = { selectedNavItem = 11 }
//                    )
//                    // Epoch
//                    NavRailItem(
//                        icon = Icons.Default.PunchClock,
//                        isSelected = selectedNavItem == 12,
//                        onClick = { selectedNavItem = 12 }
//                    )
//                    // Memory
//                    NavRailItem(
//                        icon = Icons.Default.Memory,
//                        isSelected = selectedNavItem == 13,
//                        onClick = { selectedNavItem = 13 }
//                    )
//                    // Time
//                    NavRailItem(
//                        icon = Icons.Default.LockClock,
//                        isSelected = selectedNavItem == 14,
//                        onClick = { selectedNavItem = 14 }
//                    )
//                    // MD5
//                    NavRailItem(
//                        icon = Icons.Default.Security,
//                        isSelected = selectedNavItem == 15,
//                        onClick = { selectedNavItem = 15 }
//                    )
//                    // Luhn Checker
//                    NavRailItem(
//                        icon = Icons.Default.Security,
//                        isSelected = selectedNavItem == 16,
//                        onClick = { selectedNavItem = 16 }
//                    )
                    // Unicode
                    NavRailItem(
                        icon = Icons.Default.Abc,
                        isSelected = selectedNavItem == 17,
                        onClick = { selectedNavItem = 17 }
                    )
                },
                footer = {
                    Spacer(modifier = Modifier.height(16.dp))
                    IconButton(onClick = { /* Settings action */ }) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                },
                backgroundColor = MaterialTheme.colorScheme.surfaceVariant,
                width = 56.dp
            )
        },

        // Main content implementation
        content = {

            val navigationPanelState = rememberNavigationPanelState(initialExpanded = true)
            val rotation by animateFloatAsState(
                targetValue = if (navigationPanelState.isExpanded) 0f else 180f,
                animationSpec = tween(durationMillis = 300),
                label = "Toggle Icon Rotation"
            )

            val optionalPanelState = rememberOptionalPanelState(initialExpanded = true)

            DesktopAreaScaffold(
//                navigationPanelState = navigationPanelState,
                actionBar = {},
//                navigationPanel = {},
                navigationPanelWidth = 0.dp,
//                optionalPanel = {},
//                optionalPanelState = optionalPanelState,
                optionalPanelWidth = 0.dp,
            )
            {
                // Main content area with email list and preview
                Surface(
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    when (selectedNavItem) {
                        0 -> DurationParserView()
                        1 -> UrlEncodeView()
                        2 -> GuidView()
                        3 -> Base64View()
                        5 -> AsciiView()
                        6 -> HTMLEncodeDecode()
                        7 -> HexToRgbView()
                        8 -> SQLBuilderView()
                        9 -> RemoveWhitespaceView()
                        10 -> StringConverterView()
                        11 -> BinaryView()
                        12 -> EpochView()
                        13 -> MemoryConverterView()
                        14 -> TimeConverterView()
                        15 -> MD5View()
                        16 -> LuhnChecker()
                        17 -> UnicodeView()
                        else -> App()
                    }

                }
            }
        },

        modifier = Modifier.fillMaxSize()
    )
}