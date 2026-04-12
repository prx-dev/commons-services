 ---
mode: ask
description: Route tasks to the correct project agent prompt.
---

Task routing guide:

- Interface contracts / TOs / OpenAPI -> `agents/contracts-architect.prompt.md`
- Logging flow / interceptors -> `agents/logging-flow-specialist.prompt.md`
- Cloudflare R2 / profile image pipeline -> `agents/cloudflare-r2-specialist.prompt.md`
- Config/properties/rest/util -> `agents/rest-config-maintainer.prompt.md`
- PMD/JaCoCo/build verification -> `agents/build-quality-guardian.prompt.md`
- Diff review -> `agents/code-review-auditor.prompt.md`
- CVE/dependency upgrades -> `agents/dependency-security-guardian.prompt.md`
- Release readiness -> `agents/release-publisher.prompt.md`
- Policy/docs alignment -> `agents/docs-governance-maintainer.prompt.md`

Always load:

- `shared/repo-baseline.prompt.md`
- `shared/restrictions.prompt.md`

