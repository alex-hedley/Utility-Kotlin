package com.alexhedley.components

import kotlin.test.Test
import kotlin.test.assertEquals

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
