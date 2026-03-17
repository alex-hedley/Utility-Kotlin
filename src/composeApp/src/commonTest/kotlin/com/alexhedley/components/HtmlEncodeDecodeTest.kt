package com.alexhedley.components

import kotlin.test.Test
import kotlin.test.assertEquals

class HtmlEncodeDecodeTest {

    @Test
    fun decodeEntities() {
        assertEquals("<h1>Hello</h1>", htmlDecode("&lt;h1&gt;Hello&lt;/h1&gt;"))
    }

    @Test
    fun decodeAmpersand() {
        assertEquals("a & b", htmlDecode("a &amp; b"))
    }

    @Test
    fun decodeQuotes() {
        assertEquals("say \"hi\" and it's ok", htmlDecode("say &quot;hi&quot; and it&#39;s ok"))
    }

    @Test
    fun encodeAngles() {
        assertEquals("&lt;html&gt;", htmlEncode("<html>"))
    }

    @Test
    fun encodeAmpersandFirst() {
        // & must be encoded before < and > to avoid double-encoding
        assertEquals("&amp;lt;", htmlEncode("&lt;"))
    }

    @Test
    fun encodeThenDecodeIsIdentity() {
        val original = "<div class=\"main\">Hello & 'world'</div>"
        assertEquals(original, htmlDecode(htmlEncode(original)))
    }
}
