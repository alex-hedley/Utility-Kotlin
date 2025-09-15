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
import com.alexhedley.components.Base64View
import com.alexhedley.components.DurationParserView
import com.alexhedley.components.GuidView
import com.alexhedley.components.HexToDecView
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
                    // HEX to DEC
                    NavRailItem(
                        icon = Icons.Default.Abc,
                        isSelected = selectedNavItem == 4,
                        onClick = { selectedNavItem = 4 }
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
                        4 -> HexToDecView()
                        else -> App()
                    }

                }
            }
        },

        modifier = Modifier.fillMaxSize()
    )
}