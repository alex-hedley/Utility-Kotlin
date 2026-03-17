package com.alexhedley.components

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

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
