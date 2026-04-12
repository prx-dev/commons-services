---
mode: ask
description: Skill: maintain logging interceptor chain behavior.
---

Apply this skill when changing logging interceptors.

Guardrails:

- Keep chain: `LogInterceptor -> RequestBodyInterceptor -> ResponseBodyInterceptor -> LoggingService`.
- `LogInterceptor.preHandle` supports GET/POST/PUT/DELETE and returns `true`.
- All interceptors delegate to `LoggingService`.
- Tracing flag remains `prx.logging.trace.enabled`.

