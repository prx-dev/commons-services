---
mode: ask
description: Skill: Cloudflare R2 S3 client compatibility settings.
---

Apply this skill when changing R2 client configuration.

Guardrails:

- `pathStyleAccessEnabled(true)` is required.
- `chunkedEncodingEnabled(false)` is required.
- `Region.of("auto")` is required.
- Credentials must come from `CloudflareR2Properties`.
- Never log credentials.

