package com.alexhedley.components

actual fun currentEpochSeconds(): Long = System.currentTimeMillis() / 1000L
