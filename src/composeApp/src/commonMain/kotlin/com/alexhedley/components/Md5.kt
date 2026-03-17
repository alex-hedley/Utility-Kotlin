package com.alexhedley.components

/**
 * Pure Kotlin multiplatform MD5 implementation.
 */
private val MD5_S = intArrayOf(
    7, 12, 17, 22, 7, 12, 17, 22, 7, 12, 17, 22, 7, 12, 17, 22,
    5,  9, 14, 20, 5,  9, 14, 20, 5,  9, 14, 20, 5,  9, 14, 20,
    4, 11, 16, 23, 4, 11, 16, 23, 4, 11, 16, 23, 4, 11, 16, 23,
    6, 10, 15, 21, 6, 10, 15, 21, 6, 10, 15, 21, 6, 10, 15, 21
)

private val MD5_K = intArrayOf(
    -680876936, -389564586, 606105819, -1044525330, -176418897, 1200080426,
    -1473231341, -45705983, 1770035416, -1958414417, -42063, -1990404162,
    1804603682, -40341101, -1502002290, 1236535329, -165796510, -1069501632,
    643717713, -373897302, -701558691, 38016083, -660478335, -405537848,
    568446438, -1019803690, -187363961, 1163531501, -1444681467, -51403784,
    1735328473, -1926607734, -378558, -2022574463, 1839030562, -35309556,
    -1530992060, 1272893353, -155497632, -1094730640, 681279174, -358537222,
    -722521979, 76029189, -640364487, -421815835, 530742520, -995338651,
    -198630844, 1126891415, -1416354905, -57434055, 1700485571, -1894986606,
    -1051523, -2054922799, 1873313359, -30611744, -1560198380, 1309151649,
    -145523070, -1120210379, 718787259, -343485551
)

private fun Int.leftRotate(n: Int): Int = (this shl n) or (this ushr (32 - n))

fun md5(input: String): String {
    val bytes = input.encodeToByteArray()
    val originalLen = bytes.size

    // Pre-processing: adding padding bits
    val paddedLen = ((originalLen + 8) / 64 + 1) * 64
    val padded = ByteArray(paddedLen)
    bytes.copyInto(padded)
    padded[originalLen] = 0x80.toByte()

    // Append original length in bits as 64-bit little-endian
    val bitLen = (originalLen * 8).toLong()
    for (i in 0..7) {
        padded[paddedLen - 8 + i] = ((bitLen ushr (8 * i)) and 0xFF).toByte()
    }

    var a0 = 0x67452301
    var b0 = -0x10325477 // 0xEFCDAB89
    var c0 = -0x67452302 // 0x98BADCFE
    var d0 = 0x10325476

    // Process each 512-bit chunk
    var offset = 0
    while (offset < paddedLen) {
        val m = IntArray(16) { i ->
            val j = offset + i * 4
            (padded[j].toInt() and 0xFF) or
            ((padded[j + 1].toInt() and 0xFF) shl 8) or
            ((padded[j + 2].toInt() and 0xFF) shl 16) or
            ((padded[j + 3].toInt() and 0xFF) shl 24)
        }

        var a = a0; var b = b0; var c = c0; var d = d0

        for (i in 0..63) {
            val f: Int
            val g: Int
            when {
                i < 16 -> { f = (b and c) or (b.inv() and d); g = i }
                i < 32 -> { f = (d and b) or (d.inv() and c); g = (5 * i + 1) % 16 }
                i < 48 -> { f = b xor c xor d; g = (3 * i + 5) % 16 }
                else   -> { f = c xor (b or d.inv()); g = (7 * i) % 16 }
            }
            val temp = d
            d = c
            c = b
            b = b + (a + f + MD5_K[i] + m[g]).leftRotate(MD5_S[i])
            a = temp
        }

        a0 += a; b0 += b; c0 += c; d0 += d
        offset += 64
    }

    // Produce the final hash value as a hex string (little-endian)
    fun Int.toLeHex(): String = buildString {
        for (i in 0..3) append(((this@toLeHex ushr (8 * i)) and 0xFF).toString(16).padStart(2, '0'))
    }
    return a0.toLeHex() + b0.toLeHex() + c0.toLeHex() + d0.toLeHex()
}
