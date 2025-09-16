package com.alexhedley

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Abc
import androidx.compose.material.icons.filled.Adjust
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Colorize
import androidx.compose.material.icons.filled.LockClock
import androidx.compose.material.icons.filled.Memory
import androidx.compose.material.icons.filled.Menu
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
import androidx.compose.ui.draw.rotate
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
import com.alexhedley.components.LuhnChecker
import com.alexhedley.components.MD5View
import com.alexhedley.components.MemoryConverterView
import com.alexhedley.components.RegexView
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
import net.tactware.composedesktop.scaffold.state.rememberNavigationRailState
import net.tactware.composedesktop.scaffold.state.rememberOptionalPanelState

import org.jetbrains.compose.resources.painterResource
import utility.composeapp.generated.resources.Res
import utility.composeapp.generated.resources.icon

/**
 * Example implementation of the Desktop Scaffold to test layout options.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp() {
    // State for the navigation panel

    // State for the selected navigation item
    var selectedNavItem by remember { mutableStateOf(0) }
    val navigationRailState = rememberNavigationRailState(initialExpanded = false)

    val rotation by animateFloatAsState(
        targetValue = if (navigationRailState.isExpanded) 0f else 180f,
        animationSpec = tween(durationMillis = 300),
        label = "Toggle Icon Rotation"
    )

    DesktopApplicationScaffold(
        topBar = {
            DesktopTopBar(
                title = {
                    Image(painter = painterResource(Res.drawable.icon), contentDescription = null)
                    Spacer(Modifier.width(16.dp))
                    Text("Utility")
                },
            )
        },

        // Navigation rail implementation
        navigationRail = {
            DesktopNavigationRail(
                width = 56.dp,
                expanded = navigationRailState.isExpanded,
                header = {
//                    IconButton(onClick = { /* Menu action */ }) {
//                        Icon(Icons.Default.Add, contentDescription = "Menu")
//                    }
//                    Spacer(modifier = Modifier.height(16.dp))
                    IconButton(
                        onClick = { navigationRailState.toggle() },
                        modifier = Modifier.padding(start = 8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ChevronLeft,
                            contentDescription = "Toggle Panel",
                            modifier = Modifier.rotate(rotation)
                        )
                    }
                },
                content = {
                    NavRailItem(
                        title = "Duration Parser",
                        icon = Icons.Default.Adjust,
                        expanded = navigationRailState.isExpanded,
                        isSelected = selectedNavItem == 0,
                        onClick = { selectedNavItem = 0 }
                    )
                    NavRailItem(
                        title = "URL Encode",
                        icon = Icons.Default.Code,
                        expanded = navigationRailState.isExpanded,
                        isSelected = selectedNavItem == 1,
                        onClick = { selectedNavItem = 1 }
                    )
                    NavRailItem(
                        title = "Guid",
                        icon = Icons.Default.Code,
                        expanded = navigationRailState.isExpanded,
                        isSelected = selectedNavItem == 2,
                        onClick = { selectedNavItem = 2 }
                    )
                    NavRailItem(
                        title = "Base64",
                        icon = Icons.Default.Abc,
                        expanded = navigationRailState.isExpanded,
                        isSelected = selectedNavItem == 3,
                        onClick = { selectedNavItem = 3 }
                    )
                    NavRailItem(
                        title = "Hex to DEC",
                        icon = Icons.Default.Abc,
                        expanded = navigationRailState.isExpanded,
                        isSelected = selectedNavItem == 4,
                        onClick = { selectedNavItem = 4 }
                    )
                    NavRailItem(
                        title = "ASCII",
                        icon = Icons.Default.Abc,
                        expanded = navigationRailState.isExpanded,
                        isSelected = selectedNavItem == 5,
                        onClick = { selectedNavItem = 5 }
                    )
                    NavRailItem(
                        title = "HTML Encode / Decode",
                        icon = Icons.Default.Abc,
                        expanded = navigationRailState.isExpanded,
                        isSelected = selectedNavItem == 6,
                        onClick = { selectedNavItem = 6 }
                    )
                    NavRailItem(
                        title = "HEX to RGB",
                        icon = Icons.Default.Colorize,
                        expanded = navigationRailState.isExpanded,
                        isSelected = selectedNavItem == 7,
                        onClick = { selectedNavItem = 7 }
                    )
                    NavRailItem(
                        title = "SQL Builder",
                        icon = Icons.Default.Code,
                        expanded = navigationRailState.isExpanded,
                        isSelected = selectedNavItem == 8,
                        onClick = { selectedNavItem = 8 }
                    )
                    NavRailItem(
                        title = "Remove Whitespace",
                        icon = Icons.Default.Abc,
                        expanded = navigationRailState.isExpanded,
                        isSelected = selectedNavItem == 9,
                        onClick = { selectedNavItem = 9 }
                    )
                    NavRailItem(
                        title = "String Converter",
                        icon = Icons.Default.Abc,
                        expanded = navigationRailState.isExpanded,
                        isSelected = selectedNavItem == 10,
                        onClick = { selectedNavItem = 10 }
                    )
                    NavRailItem(
                        title = "Binary",
                        icon = Icons.Default.Abc,
                        expanded = navigationRailState.isExpanded,
                        isSelected = selectedNavItem == 11,
                        onClick = { selectedNavItem = 11 }
                    )
                    NavRailItem(
                        title = "Epoch",
                        icon = Icons.Default.PunchClock,
                        expanded = navigationRailState.isExpanded,
                        isSelected = selectedNavItem == 12,
                        onClick = { selectedNavItem = 12 }
                    )
                    NavRailItem(
                        title = "Memory",
                        icon = Icons.Default.Memory,
                        expanded = navigationRailState.isExpanded,
                        isSelected = selectedNavItem == 13,
                        onClick = { selectedNavItem = 13 }
                    )
                    NavRailItem(
                        title = "Time",
                        icon = Icons.Default.LockClock,
                        expanded = navigationRailState.isExpanded,
                        isSelected = selectedNavItem == 14,
                        onClick = { selectedNavItem = 14 }
                    )
                    NavRailItem(
                        title = "MD5",
                        icon = Icons.Default.Security,
                        expanded = navigationRailState.isExpanded,
                        isSelected = selectedNavItem == 15,
                        onClick = { selectedNavItem = 15 }
                    )
                    NavRailItem(
                        title = "Luhn Checker",
                        icon = Icons.Default.Security,
                        expanded = navigationRailState.isExpanded,
                        isSelected = selectedNavItem == 16,
                        onClick = { selectedNavItem = 16 }
                    )
                    NavRailItem(
                        title = "Unicode",
                        icon = Icons.Default.Abc,
                        expanded = navigationRailState.isExpanded,
                        isSelected = selectedNavItem == 17,
                        onClick = { selectedNavItem = 17 }
                    )
                    NavRailItem(
                        title = "Regular Expression",
                        icon = Icons.Default.Abc,
                        expanded = navigationRailState.isExpanded,
                        isSelected = selectedNavItem == 18,
                        onClick = { selectedNavItem = 18 }
                    )
                },
                footer = {
//                    Spacer(modifier = Modifier.height(16.dp))
//                    IconButton(onClick = { /* Settings action */ }) {
//                        Icon(Icons.Default.Settings, contentDescription = "Settings")
//                    }
                },
                backgroundColor = MaterialTheme.colorScheme.surfaceVariant
            )
        },

        // Main content implementation
        content = {

            val navigationPanelState = rememberNavigationPanelState(initialExpanded = true)
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
                        4 -> HexToDecView()
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
                        18 -> RegexView()
                        else -> App()
                    }

                }
            }
        },

        modifier = Modifier.fillMaxSize()
    )
}