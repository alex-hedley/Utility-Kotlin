package com.alexhedley.components

import kotlin.test.Test
import kotlin.test.assertEquals

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
