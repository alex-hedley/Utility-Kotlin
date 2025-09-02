package com.alexhedley

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform