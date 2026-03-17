package com.alexhedley.components

import kotlin.test.Test
import kotlin.test.assertEquals

class RemoveWhitespaceTest {

    @Test
    fun removesSpacesBetweenWords() {
        assertEquals("helloworld", removeWhitespace("hello world"))
    }

    @Test
    fun removesTabsAndNewlines() {
        assertEquals("abc", removeWhitespace("a\tb\nc"))
    }

    @Test
    fun emptyInputReturnsEmpty() {
        assertEquals("", removeWhitespace(""))
    }

    @Test
    fun inputWithNoWhitespaceIsUnchanged() {
        assertEquals("Kotlin", removeWhitespace("Kotlin"))
    }

    @Test
    fun removesMultipleConsecutiveSpaces() {
        assertEquals("ab", removeWhitespace("a   b"))
    }
}
