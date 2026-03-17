package com.alexhedley.components

import kotlin.io.encoding.ExperimentalEncodingApi
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

// ---------------------------------------------------------------------------
// RemoveWhitespace
// ---------------------------------------------------------------------------
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

// ---------------------------------------------------------------------------
// StringConverter
// ---------------------------------------------------------------------------
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

// ---------------------------------------------------------------------------
// HexToRgb
// ---------------------------------------------------------------------------
class HexToRgbTest {

    @Test
    fun parsesBlackHex() {
        assertEquals(Triple(0, 0, 0), parseHexToRgb("#000000"))
    }

    @Test
    fun parsesWhiteHex() {
        assertEquals(Triple(255, 255, 255), parseHexToRgb("#ffffff"))
    }

    @Test
    fun parsesOrangeHex() {
        assertEquals(Triple(255, 106, 0), parseHexToRgb("#ff6a00"))
    }

    @Test
    fun worksWithoutHashPrefix() {
        assertEquals(Triple(0, 128, 0), parseHexToRgb("008000"))
    }

    @Test
    fun uppercaseHexDigits() {
        assertEquals(Triple(255, 255, 255), parseHexToRgb("#FFFFFF"))
    }

    @Test
    fun invalidHexThrows() {
        var threw = false
        try { parseHexToRgb("#12345") } catch (_: Exception) { threw = true }
        assertTrue(threw, "Expected an exception for a 5-char hex")
    }
}

// ---------------------------------------------------------------------------
// HTMLEncodeDecode
// ---------------------------------------------------------------------------
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

// ---------------------------------------------------------------------------
// MemoryConverter
// ---------------------------------------------------------------------------
class MemoryConverterTest {

    @Test
    fun oneKilobyte() {
        assertEquals("1.0", formatBytes(1024.0, 1024.0))
    }

    @Test
    fun oneMegabyte() {
        assertEquals("1.0", formatBytes(1024.0 * 1024.0, 1024.0 * 1024.0))
    }

    @Test
    fun oneGigabyteInKb() {
        assertEquals("1048576.0", formatBytes(1024.0 * 1024.0 * 1024.0, 1024.0))
    }

    @Test
    fun zeroBytesIsZero() {
        assertEquals("0.0", formatBytes(0.0, 1024.0))
    }
}

// ---------------------------------------------------------------------------
// TimeConverter
// ---------------------------------------------------------------------------
class TimeConverterTest {

    @Test
    fun zeroSeconds() {
        assertEquals("00:00:00:000", secondsToHms(0L))
    }

    @Test
    fun sixtySecondsIsOneMinute() {
        assertEquals("00:01:00:000", secondsToHms(60L))
    }

    @Test
    fun oneHour() {
        assertEquals("01:00:00:000", secondsToHms(3600L))
    }

    @Test
    fun mixedHoursMinutesSeconds() {
        assertEquals("01:01:01:000", secondsToHms(3661L))
    }

    @Test
    fun largeValue() {
        assertEquals("25:00:00:000", secondsToHms(90000L))
    }
}

// ---------------------------------------------------------------------------
// LuhnChecker
// ---------------------------------------------------------------------------
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

// ---------------------------------------------------------------------------
// Binary
// ---------------------------------------------------------------------------
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

// ---------------------------------------------------------------------------
// SQLLike
// ---------------------------------------------------------------------------
class SqlLikeTest {

    @Test
    fun basicLikeClause() {
        assertEquals("FirstName LIKE '%Alex%'", buildSqlLike("FirstName", "Alex"))
    }

    @Test
    fun emptyFieldAndValue() {
        assertEquals(" LIKE '%%'", buildSqlLike("", ""))
    }
}

// ---------------------------------------------------------------------------
// SQLContains
// ---------------------------------------------------------------------------
class SqlContainsTest {

    @Test
    fun withoutWildcard() {
        assertEquals("""CONTAINS(FirstName, '"Alex"')""", buildSqlContains("FirstName", "Alex", false))
    }

    @Test
    fun withWildcard() {
        assertEquals("""CONTAINS(FirstName, '"Alex*"')""", buildSqlContains("FirstName", "Alex", true))
    }

    @Test
    fun emptyValue() {
        assertEquals("""CONTAINS(col, '""')""", buildSqlContains("col", "", false))
    }
}

// ---------------------------------------------------------------------------
// SQLINClause
// ---------------------------------------------------------------------------
class SqlInClauseTest {

    @Test
    fun singleQuoteWrapper() {
        assertEquals("('Alice', 'Bob', 'Charlie')", buildSqlInClause("Alice\nBob\nCharlie", "'", false))
    }

    @Test
    fun doubleQuoteWrapper() {
        assertEquals("""("Alice", "Bob")""", buildSqlInClause("Alice\nBob", "\"", false))
    }

    @Test
    fun noWrapper() {
        assertEquals("(Alice, Bob)", buildSqlInClause("Alice\nBob", "", false))
    }

    @Test
    fun removeDuplicates() {
        assertEquals("('Alice', 'Bob')", buildSqlInClause("Alice\nBob\nAlice", "'", true))
    }

    @Test
    fun commaSeparatedInput() {
        assertEquals("('A', 'B', 'C')", buildSqlInClause("A, B, C", "'", false))
    }
}

// ---------------------------------------------------------------------------
// JWT Debugger
// ---------------------------------------------------------------------------
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

// ---------------------------------------------------------------------------
// Epoch Converter
// ---------------------------------------------------------------------------
class EpochTest {

    @Test
    fun unixEpochOrigin() {
        assertEquals("1970-01-01 00:00:00 UTC", epochToUtcString(0L))
    }

    @Test
    fun knownTimestamp() {
        assertEquals("2023-11-14 22:13:20 UTC", epochToUtcString(1700000000L))
    }

    @Test
    fun leapYearDay() {
        // 2000-02-29 00:00:00 UTC = 951782400
        assertEquals("2000-02-29 00:00:00 UTC", epochToUtcString(951782400L))
    }

    @Test
    fun isLeapYearDivisibleBy4() {
        assertTrue(isLeapYear(2000))
        assertTrue(isLeapYear(2004))
    }

    @Test
    fun isNotLeapYearCentury() {
        assertTrue(!isLeapYear(1900))
        assertTrue(!isLeapYear(2100))
    }
}

// ---------------------------------------------------------------------------
// MD5
// ---------------------------------------------------------------------------
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

// ---------------------------------------------------------------------------
// ASCII
// ---------------------------------------------------------------------------
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

// ---------------------------------------------------------------------------
// URL Encode/Decode
// ---------------------------------------------------------------------------
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
