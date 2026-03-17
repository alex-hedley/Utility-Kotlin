package com.alexhedley.components

import kotlin.test.Test
import kotlin.test.assertEquals

class AsciiViewTest {

    @Test
    fun singleChar() {
        assertEquals("A = 65", toAsciiValues("A"))
    }

    @Test
    fun multipleChars() {
        assertEquals("H = 72\ni = 105\n! = 33", toAsciiValues("Hi!"))
    }

    @Test
    fun emptyInput() {
        assertEquals("", toAsciiValues(""))
    }

    @Test
    fun spaceChar() {
        assertEquals("  = 32", toAsciiValues(" "))
    }
}
