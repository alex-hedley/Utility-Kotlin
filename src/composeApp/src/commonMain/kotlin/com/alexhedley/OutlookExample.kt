package com.alexhedley

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Archive
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Sync
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import net.tactware.components.EmailItem
import net.tactware.components.FolderItem
import net.tactware.components.FolderSection

import net.tactware.components.NavRailItem
import net.tactware.components.TabItem
import net.tactware.composedesktop.scaffold.components.DesktopActionBar
import net.tactware.composedesktop.scaffold.components.DesktopApplicationScaffold
import net.tactware.composedesktop.scaffold.components.DesktopAreaScaffold
import net.tactware.composedesktop.scaffold.components.DesktopNavigationRail
import net.tactware.composedesktop.scaffold.components.DesktopPanel
import net.tactware.composedesktop.scaffold.components.DesktopSearchBar
import net.tactware.composedesktop.scaffold.components.DesktopTextField
import net.tactware.composedesktop.scaffold.components.DesktopTopBar
import net.tactware.composedesktop.scaffold.components.SearchResultItem
import net.tactware.composedesktop.scaffold.state.rememberNavigationPanelState
import net.tactware.composedesktop.scaffold.state.rememberOptionalPanelState

/**
 * Example implementation of the Desktop Scaffold that mimics Microsoft Outlook's UI.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlookExample() {

//    DesktopTopBar(
//        title = {
//                    // No title in Outlook, it uses the space for the menu
//        },
//    )

    // State for the navigation panel

    // State for the selected navigation item
    var selectedNavItem by remember { mutableStateOf(0) }

    // State for the search query
    var searchQuery by remember { mutableStateOf("") }
    var showResults by remember { mutableStateOf(false) }

    // Example implementation of the Desktop Scaffold
    DesktopApplicationScaffold(
        // Top bar implementation
        topBar = {
            DesktopTopBar(
                title = {
                    // No title in Outlook, it uses the space for the menu
                },
                search = {
                    DesktopSearchBar(
                        query = searchQuery,
                        onQueryChange = { searchQuery = it },
                        onSearch = { /* Perform search */ },
                        showResults,
                        {
                            showResults = it
                        },
                        modifier = Modifier.fillMaxWidth(.5f),
                    ) {
                        Column(Modifier.fillMaxWidth(.75f)) {
                            if (searchQuery == "test") {
                                SearchResultItem(
                                    text = "Test Result 1",
                                    {}
                                )
                                SearchResultItem(
                                    text = "Test Result 2",
                                    onClick = { /* Handle click */ }
                                )
                            }
                        }
                    }
                },
                actions = {
                    // Right-side actions
                    IconButton(onClick = { /* Settings action */ }) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                    IconButton(onClick = { /* Notifications action */ }) {
                        Icon(Icons.Default.Email, contentDescription = "Notifications")
                    }
                },
                backgroundColor = MaterialTheme.colorScheme.surface,
                height = 48.dp
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
                    NavRailItem(
                        icon = Icons.Default.Email,
                        isSelected = selectedNavItem == 0,
                        onClick = { selectedNavItem = 0 }
                    )
                    NavRailItem(
                        icon = Icons.Default.Person,
                        isSelected = selectedNavItem == 1,
                        onClick = { selectedNavItem = 1 }
                    )
                    NavRailItem(
                        icon = Icons.Default.Home,
                        isSelected = selectedNavItem == 2,
                        onClick = { selectedNavItem = 2 }
                    )
                    NavRailItem(
                        icon = Icons.Default.Star,
                        isSelected = selectedNavItem == 3,
                        onClick = { selectedNavItem = 3 }
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
                navigationPanelState = navigationPanelState,
                actionBar = {
                    DesktopActionBar(
                        expansionAction = {
                            IconButton(
                                onClick = { navigationPanelState.toggle() },
                                modifier = Modifier.padding(start = 8.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = "Toggle Panel",
                                    modifier = Modifier.rotate(rotation)
                                )
                            }
                        },
                        primaryAction = {
                            // New Mail button
                            Button(
                                onClick = {
                                    optionalPanelState.toggle()
                                },
                                modifier = Modifier.padding(end = 8.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = "New Mail",
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("New Mail")
                            }
                        },
                        actions = {
                            // Other actions
                            IconButton(onClick = { /* Delete action */ }) {
                                Icon(Icons.Default.Delete, contentDescription = "Delete")
                            }
                            IconButton(onClick = { /* Archive action */ }) {
                                Icon(Icons.Default.Archive, contentDescription = "Archive")
                            }
                            IconButton(onClick = { /* Flag action */ }) {
                                Icon(Icons.Default.Flag, contentDescription = "Flag")
                            }
                            IconButton(onClick = { /* Sync action */ }) {
                                Icon(Icons.Default.Sync, contentDescription = "Sync")
                            }
                        },
                        backgroundColor = MaterialTheme.colorScheme.surface,
                        footer = {
                            IconButton({
                                optionalPanelState.toggle()
                            }, modifier = Modifier.padding(8.dp)) {
                                Icon(
                                    imageVector = if (optionalPanelState.isExpanded) Icons.Default.ChevronRight else Icons.Default.ChevronLeft,
                                    contentDescription = "Toggle Optional Panel",
                                    modifier = Modifier.rotate(rotation)
                                )
                            }
                        }
                    )
                },
                // Navigation panel implementation
                navigationPanel = {
                    DesktopPanel(
                        header = {
                            // Account information
                            Text(
                                text = "user@example.com",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(16.dp)
                            )
                        },
                        content = {


                            // Folder structure
                            FolderSection(
                                title = "Favorites",
                                items = listOf(
                                    FolderItem("Inbox", 6),
                                    FolderItem("Sent Items", 0),
                                    FolderItem("Drafts", 2)
                                )
                            )

                            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

                            FolderSection(
                                title = "Folders",
                                items = listOf(
                                    FolderItem("Inbox", 6),
                                    FolderItem("Drafts", 2),
                                    FolderItem("Sent Items", 0),
                                    FolderItem("Deleted Items", 15),
                                    FolderItem("Junk Email", 3),
                                    FolderItem("Archive", 0)
                                )
                            )
                        },
                        backgroundColor = MaterialTheme.colorScheme.surface,
                    )
                },
                optionalPanel = {
                    DesktopPanel(
                        header = {
                            // Optional panel header
                            Text(
                                text = "Optional Panel",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(16.dp)
                            )
                        },
                        content = {
                            // Optional panel content
                            Text(
                                text = "This is an optional panel.",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(16.dp)
                            )

                            DesktopTextField("Text",{}, modifier = Modifier.padding(8.dp))
                            OutlinedTextField("Text", {}, modifier = Modifier.padding(8.dp))
                        },
                        backgroundColor = MaterialTheme.colorScheme.surfaceVariant,
                        contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.fillMaxHeight(0.8f) // Adjust height as needed
                    )

                },
                optionalPanelState = optionalPanelState,
            )
            {

                // Main content area with email list and preview
                Surface(
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize().padding(16.dp)
                    ) {
                        // Tabs (Focused, Other)
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
                        ) {
                            TabItem("Focused", isSelected = true) {}
                            TabItem("Other", isSelected = false) {}
                        }

                        // Email list
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            // Email items
                            EmailItem(
                                sender = "John Doe",
                                subject = "Meeting tomorrow",
                                preview = "Hi, let's discuss the project tomorrow at 10 AM.",
                                time = "10:30 AM"
                            )
                            EmailItem(
                                sender = "Jane Smith",
                                subject = "Project update",
                                preview = "Here's the latest update on the project.",
                                time = "Yesterday"
                            )
                            EmailItem(
                                sender = "Marketing Team",
                                subject = "New campaign",
                                preview = "We're launching a new marketing campaign next week.",
                                time = "Monday"
                            )
                            EmailItem(
                                sender = "HR Department",
                                subject = "Company policy update",
                                preview = "Please review the updated company policies.",
                                time = "Last week"
                            )
                        }
                    }
                }
            }
        },

        // Modifier for the entire scaffold
        modifier = Modifier.fillMaxSize()
    )
}
