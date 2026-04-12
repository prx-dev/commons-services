---
mode: ask
description: Skill: backward compatibility for shared library APIs.
---

Apply this skill before finalizing interface or public class changes.

Guardrails:

- Do not remove or rename public methods.
- Do not change published method signatures.
- Prefer additive evolution with defaults.
- Add focused tests to document expected fallback behavior.

