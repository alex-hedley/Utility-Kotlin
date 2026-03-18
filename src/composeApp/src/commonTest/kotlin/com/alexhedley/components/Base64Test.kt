package com.alexhedley.components

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class Base64Test {

    @Test
    fun decode_alphanumericString() {
        assertEquals("AlexHedley", base64Decode("QWxleEhlZGxleQ=="))
    }

    @Test
    fun decode_helloWorld() {
        assertEquals("hello world", base64Decode("aGVsbG8gd29ybGQ="))
    }

    @Test
    fun decode_emptyString() {
        assertEquals("", base64Decode(""))
    }

    @Test
    fun encode_alphanumericString() {
        assertEquals("QWxleEhlZGxleQ==", base64Encode("AlexHedley"))
    }

    @Test
    fun encode_helloWorld() {
        assertEquals("aGVsbG8gd29ybGQ=", base64Encode("hello world"))
    }

    @Test
    fun encode_emptyString() {
        assertEquals("", base64Encode(""))
    }

    @Test
    fun roundTrip_encodeThenDecode() {
        val original = "Kotlin Multiplatform"
        assertEquals(original, base64Decode(base64Encode(original)))
    }

    @Test
    fun roundTrip_decodeThenEncode() {
        val encoded = "S290bGluIE11bHRpcGxhdGZvcm0="
        assertEquals(encoded, base64Encode(base64Decode(encoded)))
    }

    @Test
    fun decode_invalidInputThrows() {
        assertFailsWith<Exception> { base64Decode("!!!not-valid-base64!!!") }
    }
}
