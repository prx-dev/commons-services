---
mode: ask
description: Shared hard restrictions for commons-services prompts.
---

Never do the following unless explicitly approved:

- Break public interface signatures.
- Use raw HTTP status literals in `ProfileImageApi`.
- Introduce per-endpoint logging bypasses.
- Change Cloudflare R2 required S3 settings.
- Log Cloudflare access/secret keys.
- Disable PMD or lower JaCoCo thresholds.
- Add Lombok.
- Use `@Autowired` field injection.
- Commit credentials, tokens, or secrets.
- Modify `.github/workflows/`.

Implementation style:

- Constructor injection only.
- SLF4J logging only.
- Explicit getters/setters for `@ConfigurationProperties` classes.
- Use Java records for TOs.
- MapStruct mappers use `config = MapperAppConfig.class`.

