---
mode: ask
description: Skill: keep PMD and JaCoCo gates passing.
---

Apply this skill when code or tests change.

Guardrails:

- PMD active in `test` phase with fail-on-violation.
- JaCoCo enforced in `verify` phase.
- Keep line >= 80% and branch >= 50% thresholds.
- Do not broaden exclusions without approval.

