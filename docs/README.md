# Docs

- [Progress](PROGRESS.md)
- [Testing](TESTING.md)
- [Articles](ARTICLES.md)
- [Deployment](DEPLOYMENT.md)
- [Acknowledgements](ACKNOWLEDGEMENTS.md)
- [Contributors](CONTRIBUTORS.md)

---

## 🔗 Useful Links

- https://foso.github.io/Jetpack-Compose-Playground/

---

## Getting Started

- https://kotlinlang.org/docs/wasm-get-started.html#before-you-start
- https://kmp.jetbrains.com/?web=true&includeTests=true

### wasm

- ▶️[wasm.run.xml](../src/.run/wasm.run.xml)

In wasmdemo | Tasks | kotlin browser, select and run the wasmJsBrowserDevelopmentRun task.

`./gradlew wasmJsBrowserDevelopmentRun`

`./gradlew wasmJsBrowserDevelopmentRun -t`

Opens

- http://localhost:8081
- http://localhost:8080

---

- ▶️[Distribution.run.xml](../src/.run/Distribution.run.xml)

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

### Desktop

- ▶️[Desktop.run.xml](../src/.run/Desktop.run.xml)

`./gradlew run`

`./gradlew run -t`
