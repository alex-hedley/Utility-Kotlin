package com.alexhedley.components

import kotlin.test.Test
import kotlin.test.assertEquals

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
