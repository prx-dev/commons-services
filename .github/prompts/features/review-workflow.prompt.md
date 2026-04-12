---
mode: ask
description: Feature workflow for severity-first code review.
---

Use this workflow to run a full review:

1. Load `.github/prompts/shared/repo-baseline.prompt.md`.
2. Load `.github/prompts/shared/restrictions.prompt.md`.
3. Apply `.github/prompts/agents/code-review-auditor.prompt.md`.
4. Apply `.github/prompts/skills/api-compatibility.prompt.md`.
5. Apply `.github/prompts/skills/quality-gates-enforcement.prompt.md`.

Output:

- Findings first by severity with `file:line`.
- Open questions/assumptions.
- Short change summary.

