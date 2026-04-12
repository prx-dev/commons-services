---
mode: ask
description: Feature workflow for dependency CVE triage and remediation.
---

Use this workflow when auditing `pom.xml` dependencies:

1. Apply `.github/prompts/agents/dependency-security-guardian.prompt.md`.
2. Apply `.github/prompts/skills/api-compatibility.prompt.md`.
3. Propose minimal safe version upgrades.
4. Re-run verify path after updates.

Rules:

- Keep Java 21 and Spring Boot 3.5.8 baseline unless explicitly migrating.
- Do not add unrelated dependency changes.

