package com.alexhedley.components

import kotlin.js.JsFun

@JsFun("() => Date.now()")
private external fun jsDateNow(): Double

actual fun currentEpochSeconds(): Long = jsDateNow().toLong() / 1000L
