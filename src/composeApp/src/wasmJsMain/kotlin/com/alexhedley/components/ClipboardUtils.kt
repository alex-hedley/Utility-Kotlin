package com.alexhedley.components

import androidx.compose.ui.platform.ClipEntry

actual fun String.toClipEntry(): ClipEntry = ClipEntry.withPlainText(this)
