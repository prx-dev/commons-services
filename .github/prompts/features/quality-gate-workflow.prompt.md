---
mode: ask
description: Feature workflow to keep PMD and JaCoCo gates healthy.
---

Use this workflow after non-trivial code changes:

1. Apply `.github/prompts/agents/build-quality-guardian.prompt.md`.
2. Apply `.github/prompts/skills/quality-gates-enforcement.prompt.md`.
3. Run `mvn -DskipITs clean verify`.
4. If Byte Buddy compatibility fails, retry with the documented workaround.

Expected result:

- PMD passes.
- JaCoCo thresholds remain satisfied.

