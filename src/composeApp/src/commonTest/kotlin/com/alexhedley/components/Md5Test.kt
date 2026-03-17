package com.alexhedley.components

import kotlin.test.Test
import kotlin.test.assertEquals

class Md5Test {

    @Test
    fun emptyString() {
        assertEquals("d41d8cd98f00b204e9800998ecf8427e", md5(""))
    }

    @Test
    fun helloWorld() {
        assertEquals("5eb63bbbe01eeed093cb22bb8f5acdc3", md5("hello world"))
    }

    @Test
    fun abc() {
        assertEquals("900150983cd24fb0d6963f7d28e17f72", md5("abc"))
    }

    @Test
    fun quickBrownFox() {
        assertEquals("9e107d9d372bb6826bd81d3542a419d6", md5("The quick brown fox jumps over the lazy dog"))
    }
}
