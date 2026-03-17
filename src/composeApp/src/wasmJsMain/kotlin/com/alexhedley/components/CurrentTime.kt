package com.alexhedley.components

@OptIn(ExperimentalWasmJsInterop::class)
@JsFun("() => Date.now()")
private external fun jsDateNow(): Double

actual fun currentEpochSeconds(): Long = jsDateNow().toLong() / 1000L
