---
mode: ask
description: Shared repository baseline for commons-services prompts.
---

Use this baseline for all tasks in this repository:

- Artifact: `com.prx:commons-services:0.0.1`
- Type: shared library JAR (not a runnable app)
- Java: 21
- Spring Boot: 3.5.8
- Spring Cloud: 2025.0.1
- Build source of truth: `pom.xml`

Core invariant defaults:

- `CrudService` default methods return HTTP 501 (`HttpStatus.NOT_IMPLEMENTED`).
- `ProfileImageService` default methods throw `UnsupportedOperationException("Not implemented")`.
- `ProfileImageApi` defaults use `ResponseEntity.status(HttpStatusUtil.NOT_IMPLEMENTED)`.

Cloudflare R2 non-negotiables:

- `pathStyleAccessEnabled(true)`
- `chunkedEncodingEnabled(false)`
- `Region.of("auto")`

Quality gates:

- PMD violations priority <= 5 must fail build.
- JaCoCo line >= 80% bundle.
- JaCoCo branch >= 50% package.

