package com.alexhedley.components

import kotlin.io.encoding.ExperimentalEncodingApi
import kotlin.test.Test
import kotlin.test.assertEquals

class JwtDebuggerTest {

    @Test
    fun base64PaddingNoPadNeeded() {
        assertEquals("abcd", addBase64Padding("abcd"))
    }

    @Test
    fun base64PaddingOnePadChar() {
        assertEquals("abc=", addBase64Padding("abc"))
    }

    @Test
    fun base64PaddingTwoPadChars() {
        assertEquals("ab==", addBase64Padding("ab"))
    }

    @OptIn(ExperimentalEncodingApi::class)
    @Test
    fun decodeBase64UrlHeader() {
        val decoded = decodeBase64Url("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9")
        assertEquals("""{"alg":"HS256","typ":"JWT"}""", decoded)
    }

    @OptIn(ExperimentalEncodingApi::class)
    @Test
    fun decodeBase64UrlPayload() {
        val decoded = decodeBase64Url("eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ")
        assertEquals("""{"sub":"1234567890","name":"John Doe","iat":1516239022}""", decoded)
    }
}
