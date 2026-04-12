---
mode: ask
description: Skill: configuration properties and mapping consistency.
---

Apply this skill for `@ConfigurationProperties` updates.

Guardrails:

- Constructor injection only.
- Explicit getters/setters.
- No Lombok.
- Keep prefixes aligned with policy (`cloudflare.r2`, `prx.security`, `security.discovery.client`).

