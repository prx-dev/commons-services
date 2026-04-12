---
mode: ask
description: Feature workflow for release readiness checks.
---

Use this workflow before `mvn clean deploy`:

1. Apply `.github/prompts/agents/release-publisher.prompt.md`.
2. Confirm verify command has passed.
3. Confirm release credentials are present in environment.
4. Confirm no secrets are staged in git.

Never publish if quality gates fail.

