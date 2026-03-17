package com.alexhedley.components

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class HexToRgbTest {

    @Test
    fun parsesBlackHex() {
        assertEquals(Triple(0, 0, 0), parseHexToRgb("#000000"))
    }

    @Test
    fun parsesWhiteHex() {
        assertEquals(Triple(255, 255, 255), parseHexToRgb("#ffffff"))
    }

    @Test
    fun parsesOrangeHex() {
        assertEquals(Triple(255, 106, 0), parseHexToRgb("#ff6a00"))
    }

    @Test
    fun worksWithoutHashPrefix() {
        assertEquals(Triple(0, 128, 0), parseHexToRgb("008000"))
    }

    @Test
    fun uppercaseHexDigits() {
        assertEquals(Triple(255, 255, 255), parseHexToRgb("#FFFFFF"))
    }

    @Test
    fun invalidHexThrows() {
        var threw = false
        try { parseHexToRgb("#12345") } catch (_: Exception) { threw = true }
        assertTrue(threw, "Expected an exception for a 5-char hex")
    }
}
