---
mode: ask
description: Feature workflow to keep docs and policies synchronized.
---

Use this workflow after policy or architecture changes:

1. Apply `.github/prompts/agents/docs-governance-maintainer.prompt.md`.
2. Reconcile `AGENTS.md`, `CLAUDE.md`, and `.github/copilot-instructions.md`.
3. Reconcile `.ai/*.yml` with `.github/prompts/*`.
4. Update catalog docs (`.github/prompts/README.md`).

Goal:

- No drift between policy docs and machine-readable prompt definitions.

