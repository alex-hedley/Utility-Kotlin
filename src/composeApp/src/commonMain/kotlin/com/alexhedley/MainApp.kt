package com.alexhedley

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Abc
import androidx.compose.material.icons.filled.Adjust
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Colorize
import androidx.compose.material.icons.filled.LockClock
import androidx.compose.material.icons.filled.Memory
import androidx.compose.material.icons.filled.PunchClock
import androidx.compose.material.icons.filled.Security
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
import com.alexhedley.models.Component

import net.tactware.components.NavRailItem
import net.tactware.composedesktop.scaffold.components.DesktopApplicationScaffold
import net.tactware.composedesktop.scaffold.components.DesktopAreaScaffold
import net.tactware.composedesktop.scaffold.components.DesktopNavigationRail
import net.tactware.composedesktop.scaffold.components.DesktopTopBar
//import net.tactware.composedesktop.scaffold.state.rememberNavigationPanelState
import net.tactware.composedesktop.scaffold.state.rememberNavigationRailState
//import net.tactware.composedesktop.scaffold.state.rememberOptionalPanelState

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
    // State for the navigation rail
    val navigationRailState = rememberNavigationRailState(initialExpanded = false)
    val rotation by animateFloatAsState(
        targetValue = if (navigationRailState.isExpanded) 0f else 180f,
        animationSpec = tween(durationMillis = 300),
        label = "Toggle Icon Rotation"
    )

    // Components
    val components = listOf<Component>(
        Component(0, "Applications", "", Icons.Default.Apps, { selectedNavItem = 0 }, ComponentsView(emptyList())),
        Component(1, "Duration Parser", "", Icons.Default.Adjust, onClick = { selectedNavItem = 1 }, DurationParserView()),
        Component(2, "URL Encode", "", Icons.Default.Code, onClick = { selectedNavItem = 2 }, UrlEncodeView()),
        Component(3, "Guid", "", Icons.Default.Code, onClick = { selectedNavItem = 3 }, GuidView()),
        Component(4, "Base64", "", Icons.Default.Abc, onClick = { selectedNavItem = 4 }, Base64View()),
        Component(5, "HEX to DEC", "", Icons.Default.Abc, onClick = { selectedNavItem = 5 }, HexToDecView()),
        Component(6, "ASCII", "", Icons.Default.Abc, onClick = { selectedNavItem = 6 }, AsciiView()),
        Component(7, "HTML Encode / Decode", "", Icons.Default.Abc, onClick = { selectedNavItem = 7 }, HTMLEncodeDecode()),
        Component(8, "HEX to RGB", "", Icons.Default.Colorize, onClick = { selectedNavItem = 8 }, HexToRgbView()),
        Component(9, "SQL Builder", "", Icons.Default.Code, onClick = { selectedNavItem = 9 }, SQLBuilderView()),
        Component(10, "Remove Whitespace", "", Icons.Default.Abc, onClick = { selectedNavItem = 10 }, RemoveWhitespaceView()),
        Component(11, "String Converter", "", Icons.Default.Abc, onClick = { selectedNavItem = 11 }, StringConverterView()),
        Component(12, "Binary", "", Icons.Default.Abc, onClick = { selectedNavItem = 12 }, BinaryView()),
        Component(13, "Epoch", "", Icons.Default.PunchClock, onClick = { selectedNavItem = 13 }, EpochView()),
        Component(14, "Memory", "", Icons.Default.Memory, onClick = { selectedNavItem = 14 }, MemoryConverterView()),
        Component(15, "Time", "", Icons.Default.LockClock, onClick = { selectedNavItem = 15 }, TimeConverterView()),
        Component(16, "MD5", "", Icons.Default.Security, onClick = { selectedNavItem = 16 }, MD5View()),
        Component(17, "Luhn Checker", "", Icons.Default.Security, onClick = { selectedNavItem = 17 }, LuhnChecker()),
        Component(18, "Unicode", "", Icons.Default.Abc, onClick = { selectedNavItem = 18 }, UnicodeView()),
        Component(19, "Regex", "", Icons.Default.Abc, onClick = { selectedNavItem = 19 }, RegexView()),
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
                    components.forEach { component ->
                        NavRailItem(
                            title = component.name,
                            icon = component.icon,
                            expanded = navigationRailState.isExpanded,
                            isSelected = selectedNavItem == component.id,
                            onClick = { selectedNavItem = component.id }
                        )
                    }
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

//            val navigationPanelState = rememberNavigationPanelState(initialExpanded = true)
//            val optionalPanelState = rememberOptionalPanelState(initialExpanded = true)

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
                        0 -> ComponentsView(components)
                        1 -> DurationParserView()
                        2 -> UrlEncodeView()
                        3 -> GuidView()
                        4 -> Base64View()
                        5 -> HexToDecView()
                        6 -> AsciiView()
                        7 -> HTMLEncodeDecode()
                        8 -> HexToRgbView()
                        9 -> SQLBuilderView()
                        10 -> RemoveWhitespaceView()
                        11 -> StringConverterView()
                        12 -> BinaryView()
                        13 -> EpochView()
                        14 -> MemoryConverterView()
                        15 -> TimeConverterView()
                        16 -> MD5View()
                        17 -> LuhnChecker()
                        18 -> UnicodeView()
                        19 -> RegexView()
                        else -> App()
//                        else -> components[selectedNavItem].view
                    }
                }
            }
        },

        modifier = Modifier.fillMaxSize()
    )
}