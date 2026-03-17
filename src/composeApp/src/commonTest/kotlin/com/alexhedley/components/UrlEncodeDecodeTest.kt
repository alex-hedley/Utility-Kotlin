package com.alexhedley.components

import kotlin.test.Test
import kotlin.test.assertEquals

class UrlEncodeDecodeTest {

    @Test
    fun encodeSpace() {
        assertEquals("hello+world", urlEncode("hello world"))
    }

    @Test
    fun encodeSpecialChars() {
        val encoded = urlEncode("https://example.com/path?q=hello world&lang=en")
        assertEquals("https%3A%2F%2Fexample.com%2Fpath%3Fq%3Dhello+world%26lang%3Den", encoded)
    }

    @Test
    fun decodeEncodedUrl() {
        val decoded = urlDecode("https%3A%2F%2Fexample.com%2Fpath%3Fq%3Dhello+world%26lang%3Den")
        assertEquals("https://example.com/path?q=hello world&lang=en", decoded)
    }

    @Test
    fun roundTrip() {
        val original = "https://example.com/search?q=kotlin multiplatform&sort=asc"
        assertEquals(original, urlDecode(urlEncode(original)))
    }

    @Test
    fun unreservedCharsUnchanged() {
        val s = "abcABC123-_.~"
        assertEquals(s, urlEncode(s))
    }

    @Test
    fun encodeUnicode() {
        // '€' UTF-8 is 3 bytes: E2 82 AC
        val encoded = urlEncode("€")
        assertEquals("%E2%82%AC", encoded)
    }

    @Test
    fun decodeUnicode() {
        assertEquals("€", urlDecode("%E2%82%AC"))
    }
}
