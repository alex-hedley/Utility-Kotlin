# Utility-Kotlin

<!-- [![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=OpenJDK&logoColor=white)](https://www.java.com/en/) -->
[![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)](https://kotlinlang.org)
[![Gradle](https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white)](https://gradle.org)
[![License: MIT](https://img.shields.io/badge/License-MIT-lightgrey.svg?style=for-the-badge)](https://opensource.org/licenses/MIT)

[![Dependabot Updates](https://github.com/alex-hedley/Utility-Kotlin/actions/workflows/dependabot/dependabot-updates/badge.svg)](https://github.com/alex-hedley/Utility-Kotlin/actions/workflows/dependabot/dependabot-updates)
[![Publish Application on GitHub Pages](https://github.com/alex-hedley/Utility-Kotlin/actions/workflows/ci.yml/badge.svg)](https://github.com/alex-hedley/Utility-Kotlin/actions/workflows/ci.yml)

> Utility app built in Kotlin

## Site

- https://alex-hedley.github.io/Utility-Kotlin/

## Features


| Component | Example Input → Output |
|-----------|----------------------|
| **Remove Whitespace** | `h e l l o   w o r l d` → `helloworld` |
| **String Converter** | `Hello World` → `Hello world` (Sentence case selected) |
| **HEX to RGB** | `#ff6a00` → R: 255, G: 106, B: 0 (with colour swatch) |
| **HTML Encode/Decode** | `&lt;h1&gt;Hello&lt;/h1&gt;` ⇄ `<h1>Hello</h1>` |
| **Memory Converter** | `1073741824` bytes → KB: 1048576.0 / MB: 1024.0 / GB: 1.0 / TB: 0.001 |
| **Time Converter** | `3661` seconds → `01:01:01:000` |
| **Luhn Checker** | `4532015112830366` → **Valid** |
| **Binary** | `01101000 01100101...` ↓ `hello` / `hello` ↑ binary |
| **SQL LIKE** | Field: `FirstName`, Value: `Alex` → `FirstName LIKE '%Alex%'` |
| **SQL CONTAINS** | Field: `FirstName`, Value: `Alex` → `CONTAINS(FirstName, '"Alex"')` |
| **SQL IN Clause** | `Alice\nBob\nCharlie` → `('Alice', 'Bob', 'Charlie')` |
| **JWT Debugger** | Token → decoded HEADER: `{"alg":"HS256","typ":"JWT"}`, PAYLOAD: `{"sub":"1234567890"}` |
| **Epoch Converter** | `1700000000` → `GMT: 2023-11-14 22:13:20 UTC` |
| **MD5** | `hello world` → `5eb63bbbe01eeed093cb22bb8f5acdc3` |
| **ASCII** | `Hi!` → `H = 72`, `i = 105`, `! = 33` |
| **URL Encode/Decode** | `https://example.com/path?q=hello world` ⇄ `https%3A%2F%2F...` |

- Duration Parser
<!-- - HTML Encode/Decode #8 -->
- URL Encode #9
<!-- - HEX to RGB #10 -->
<!-- - SQL Builder (IN Clause) #11 -->
- Guid #12
<!-- - JSON Pretty #13 -->
<!-- - XML Pretty #14 -->
<!-- - SQL Formatter #15 -->
  <!-- - SQL LIKE -->
  <!-- - SQL IN - Filter Duplicates -->
<!-- - Remove whitespace #16 -->
<!-- - String Convert #17 -->
<!-- - Diff #18 -->
<!-- - Binary #19 -->
<!-- - Epoch Converter #20 -->
<!-- - Ascii Checker #21 -->
<!-- - kb - mb - gb converter #22 -->
<!-- - time converter #23 -->
<!-- - MD5 #24 -->
<!-- - Hidden Character Finder #25 -->
<!-- - Luhn Checker #26 -->
<!-- - Unicode #27 -->
<!-- - String Tools - Regular Expression #35 -->
- String Tools - Base64 Encode/Decode #36
<!-- - TOTP Token Generator #38 -->
- HEX to DEC #39
<!-- - SQL Formatter - Contains #41 -->
<!-- - JWT #61 -->

[Progress](docs/PROGRESS.md)

![Utility](docs/images/Utility.png "Utility")
![Info](docs/images/Info.png "Info")

## src

- [src](src/README.md)

Initial app template built from https://kmp.jetbrains.com/?web=true&includeTests=true

## Docs

- [Docs](docs/README.md)
- [Deployment](docs/DEPLOYMENT.md)

## Related

- https://alexhedley.com/Utility/
  - https://alexhedley.github.io/Utility-Web/
  - https://alexhedley.github.io/Utility-Blazor/
