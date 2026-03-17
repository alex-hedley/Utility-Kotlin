package com.alexhedley.components

import kotlin.test.Test
import kotlin.test.assertEquals

class LuhnCheckerTest {

    @Test
    fun validVisaCard() {
        assertEquals("Valid", luhnCheck("4532015112830366"))
    }

    @Test
    fun invalidNumber() {
        assertEquals("Invalid", luhnCheck("1234567890123456"))
    }

    @Test
    fun emptyInputIsInvalid() {
        assertEquals("Invalid: no digits found", luhnCheck(""))
    }

    @Test
    fun nonDigitInputIsInvalid() {
        assertEquals("Invalid: no digits found", luhnCheck("abcdef"))
    }

    @Test
    fun singleZeroIsValid() {
        // Single digit 0 → sum=0 → 0 % 10 == 0 → Valid
        assertEquals("Valid", luhnCheck("0"))
    }
}
