package com.alexhedley.components

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class HexToDecTest {

    @Test
    fun hexToDec_singleDigit() {
        assertEquals("18", hexToDec("12"))
    }

    @Test
    fun hexToDec_lowerCaseLetters() {
        assertEquals("255", hexToDec("ff"))
    }

    @Test
    fun hexToDec_upperCaseLetters() {
        assertEquals("255", hexToDec("FF"))
    }

    @Test
    fun hexToDec_zero() {
        assertEquals("0", hexToDec("0"))
    }

    @Test
    fun hexToDec_largeValue() {
        assertEquals("4294967295", hexToDec("FFFFFFFF"))
    }

    @Test
    fun hexToDec_invalidInputThrows() {
        assertFailsWith<NumberFormatException> { hexToDec("xyz") }
    }

    @Test
    fun decToHex_positiveValue() {
        assertEquals("12", decToHex("18"))
    }

    @Test
    fun decToHex_zero() {
        assertEquals("0", decToHex("0"))
    }

    @Test
    fun decToHex_maxByte() {
        assertEquals("ff", decToHex("255"))
    }

    @Test
    fun decToHex_largeValue() {
        assertEquals("ffffffff", decToHex("4294967295"))
    }

    @Test
    fun decToHex_invalidInputThrows() {
        assertFailsWith<NumberFormatException> { decToHex("abc") }
    }

    @Test
    fun roundTrip_hexToDecToHex() {
        assertEquals("ff", decToHex(hexToDec("ff")))
    }
}
