package com.alexhedley.components

import kotlin.test.Test
import kotlin.test.assertEquals

class StringConverterTest {

    @Test
    fun sentenceCase() {
        assertEquals("Hello world", convertString("hello world", "Sentence case"))
    }

    @Test
    fun lowerCase() {
        assertEquals("hello world", convertString("Hello World", "lower case"))
    }

    @Test
    fun upperCase() {
        assertEquals("HELLO WORLD", convertString("Hello World", "UPPER CASE"))
    }

    @Test
    fun capitalizedCase() {
        assertEquals("Hello World", convertString("hello world", "Capitalized Case"))
    }

    @Test
    fun alternatingCase() {
        // indices 0,2,4… → lower; 1,3,5… → upper
        assertEquals("hElLo", convertString("hello", "aLtErNaTiNg cAsE"))
    }

    @Test
    fun titleCase() {
        assertEquals("Hello World", convertString("hello world", "Title Case"))
    }

    @Test
    fun inverseCase() {
        assertEquals("hELLO wORLD", convertString("Hello World", "InVeRsE CaSe"))
    }

    @Test
    fun unknownOptionReturnsInput() {
        assertEquals("Hello", convertString("Hello", "unknown option"))
    }
}
