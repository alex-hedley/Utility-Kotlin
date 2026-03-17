package com.alexhedley.components

import kotlin.test.Test
import kotlin.test.assertEquals

class MemoryConverterTest {

    @Test
    fun oneKilobyte() {
        assertEquals("1.0", formatBytes(1024.0, 1024.0))
    }

    @Test
    fun oneMegabyte() {
        assertEquals("1.0", formatBytes(1024.0 * 1024.0, 1024.0 * 1024.0))
    }

    @Test
    fun oneGigabyteInKb() {
        assertEquals("1048576.0", formatBytes(1024.0 * 1024.0 * 1024.0, 1024.0))
    }

    @Test
    fun zeroBytesIsZero() {
        assertEquals("0.0", formatBytes(0.0, 1024.0))
    }
}
