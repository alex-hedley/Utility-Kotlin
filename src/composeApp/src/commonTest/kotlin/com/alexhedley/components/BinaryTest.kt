package com.alexhedley.components

import kotlin.test.Test
import kotlin.test.assertEquals

class BinaryTest {

    @Test
    fun decodeSingleByte() {
        assertEquals("A", binaryToText("01000001"))
    }

    @Test
    fun decodeMultipleBytes() {
        assertEquals("hi", binaryToText("01101000 01101001"))
    }

    @Test
    fun encodeText() {
        assertEquals("01101000 01101001", textToBinary("hi"))
    }

    @Test
    fun roundTrip() {
        val original = "Hello"
        assertEquals(original, binaryToText(textToBinary(original)))
    }
}
