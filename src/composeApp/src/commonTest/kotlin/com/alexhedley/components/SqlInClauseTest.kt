package com.alexhedley.components

import kotlin.test.Test
import kotlin.test.assertEquals

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
