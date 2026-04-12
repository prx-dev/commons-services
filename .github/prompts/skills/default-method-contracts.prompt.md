---
mode: ask
description: Skill: safe default methods in published interfaces.
---

Apply this skill when changing shared interfaces.

Guardrails:

- New interface methods must include safe defaults.
- `CrudService` defaults return `HttpStatus.NOT_IMPLEMENTED`.
- `ProfileImageService` defaults throw `UnsupportedOperationException("Not implemented")`.
- `ProfileImageApi` defaults use `HttpStatusUtil.NOT_IMPLEMENTED`.
- Avoid breaking existing public signatures.

