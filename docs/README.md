# Docs

- https://kotlinlang.org/docs/wasm-get-started.html#before-you-start
- https://kmp.jetbrains.com/?web=true&includeTests=true

In wasmdemo | Tasks | kotlin browser, select and run the wasmJsBrowserDevelopmentRun task.

`./gradlew wasmJsBrowserDevelopmentRun`

`./gradlew wasmJsBrowserDevelopmentRun -t`

Opens

- http://localhost:8081
- http://localhost:8080

In wasmdemo | Tasks | kotlin browser, select and run the wasmJsBrowserDistribution task.

`./gradlew wasmJsBrowserDistribution`

Navigate to [index.html](src/composeApp/build/dist/wasmJs/productionExecutable/index.html) (src/composeApp/build/dist/wasmJs/productionExecutable/index.html)

> [Error] Cross origin requests are only supported for HTTP.
> [Error] XMLHttpRequest cannot load file:///Users/alex.hedley/Documents/GitHub/AH/Utility-Kotlin/src/composeApp/build/dist/wasmJs/productionExecutable/8bc1b48ee28fd6b51bb9.wasm due to access control checks.
> [Error] failed to asynchronously prepare wasm: [object XMLHttpRequestProgressEvent]
> [Error] Aborted([object XMLHttpRequestProgressEvent])
> [Error] Unhandled Promise Rejection: RuntimeError: Aborted([object XMLHttpRequestProgressEvent]). Build with -sASSERTIONS for more info.
> [Error] Not allowed to load local resource: file:///favicon.ico

Run a server

`python3 -m http.server -b 127.0.0.1`

- http://localhost:8000
