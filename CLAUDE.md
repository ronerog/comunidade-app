# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Academic project (CESMAC) — a community volunteer service platform connecting citizens who need help with volunteer service providers. Built as a microservices monorepo.

## Infrastructure — Local Dev Environment

All infrastructure runs via Docker Compose. The `.env` file in `infra/` provides credentials.

```bash
# Start all infrastructure
cd infra && docker compose --env-file .env up -d

# Stop
cd infra && docker compose down
```

| Service     | URL / Port                               | Purpose                        |
|-------------|------------------------------------------|--------------------------------|
| Keycloak    | http://localhost:8080 (admin console: /admin) | IAM / SSO — realm: `comunidade` |
| RabbitMQ    | http://localhost:15672 (management UI)   | Message broker                 |
| Mailpit     | http://localhost:8025                    | Fake SMTP for dev email testing |
| PostgreSQL (identity) | localhost:5432 — `identity_db` | Users & profiles DB            |
| PostgreSQL (catalog)  | localhost:5433 — `catalog_db`  | Services catalog DB            |
| Redis       | localhost:6379                           | Cache & rate limiting          |

## Backend — Java / Spring Boot Services

Each service is an independent Maven project under `backend/`. Spring Boot version: **4.0.6** (not 3.x). Java version: **21**.

### Service ports
| Service              | Port  | Base path              |
|----------------------|-------|------------------------|
| api-gateway          | 8080  | (entry point)          |
| identity-user-service| 8081  | `/api/v1/users`        |
| notification-service | 8082  | `/api/v1/notifications`|
| service-catalog      | 8083  | `/api/v1/services`     |

### Build & run a service

```bash
# From the service directory (e.g. backend/identity-user-service)
./mvnw spring-boot:run

# Build JAR
./mvnw package -DskipTests

# Run tests
./mvnw test

# Run a single test class
./mvnw test -Dtest=ClassName

# Run a single test method
./mvnw test -Dtest=ClassName#methodName
```

### Package structure (same pattern across services)

```
com.comunidade.<service>/
├── api/            # REST controllers and DTOs
├── config/         # Spring config beans (Security, RabbitMQ, Redis)
├── consumer/       # @RabbitListener event consumers
├── domain/
│   ├── model/      # JPA entities
│   └── repository/ # Spring Data JPA repositories
├── events/         # Event POJO classes (published/consumed via RabbitMQ)
├── publisher/      # RabbitTemplate event publishers
├── service/        # Business logic
└── integration/    # External HTTP clients (e.g. ViaCEP)
```

### Key architectural patterns

- **Authentication**: Each service is an OAuth2 Resource Server validating JWTs issued by Keycloak (`http://localhost:8080/realms/comunidade`). The API Gateway validates the token at the edge and forwards requests downstream.
- **Database migrations**: Flyway controls all DDL. Scripts are in `src/main/resources/db/migration/`. Hibernate is set to `validate` (never generates DDL).
- **Async events via RabbitMQ**: `identity-user-service` publishes `user.registered` → consumed by `notification-service` and `service-catalog`. `service-catalog` publishes `service.published`.
- **Redis cache**: Used in `identity-user-service` and `service-catalog` for caching profiles and the service listing (vitrine). Cache keys follow `@Cacheable`/`@CacheEvict` annotations.
- **ViaCEP integration**: `identity-user-service` fetches Brazilian address data from the public ViaCEP API via `ViaCepClient` when registering users.
- **Domain model**: `BaseUser` (JPA inheritance) → `ClientUser` (citizens) and `ProviderUser` (volunteers). `Address` is 1:1 with `BaseUser`. `UserStatus` enum: `PENDING`, `ACTIVE`, `BLOCKED`.

### Environment variables (services read from env or defaults)

```
POSTGRES_USER, POSTGRES_PASSWORD, POSTGRES_DB, CATALOG_DB
RABBITMQ_USER, RABBITMQ_PASS
REDIS_PASSWORD
```

## Frontend — Next.js / React

**Important**: This project uses Next.js **16.2.4** with React **19.2.4** and Tailwind CSS **v4**. These are newer than most training data — read `node_modules/next/dist/docs/` before writing Next.js-specific code; APIs and conventions may differ significantly.

```bash
cd frontend
npm install
npm run dev      # http://localhost:3000
npm run build
npm run lint     # eslint (v9, flat config)
```

## Documentation

Architecture details, functional requirements, entity-relationship model, and class mappings are in [docs/](docs/):

- [docs/1-arquitetura.md](docs/1-arquitetura.md) — Architecture overview with Mermaid diagram
- [docs/2-especificacoes_funcionalidades.md](docs/2-especificacoes_funcionalidades.md) — Functional requirements (RFs)
- [docs/3-modelo_entidade_relacionamento.md](docs/3-modelo_entidade_relacionamento.md) — MER
- [docs/4-mapeamento_de_classes.md](docs/4-mapeamento_de_classes.md) — Class/package mapping

## Current implementation state

Most service classes are scaffolded with detailed TODO comments describing what to implement and in which phase. The codebase is organized in numbered phases (Fase 1–8). When implementing a TODO, read the surrounding comments carefully — they contain design decisions, naming conventions, and cross-service contracts that must be respected.

# CLAUDE.md

Behavioral guidelines to reduce common LLM coding mistakes. Merge with project-specific instructions as needed.

**Tradeoff:** These guidelines bias toward caution over speed. For trivial tasks, use judgment.

## 1. Think Before Coding

**Don't assume. Don't hide confusion. Surface tradeoffs.**

Before implementing:
- State your assumptions explicitly. If uncertain, ask.
- If multiple interpretations exist, present them - don't pick silently.
- If a simpler approach exists, say so. Push back when warranted.
- If something is unclear, stop. Name what's confusing. Ask.

## 2. Simplicity First

**Minimum code that solves the problem. Nothing speculative.**

- No features beyond what was asked.
- No abstractions for single-use code.
- No "flexibility" or "configurability" that wasn't requested.
- No error handling for impossible scenarios.
- If you write 200 lines and it could be 50, rewrite it.

Ask yourself: "Would a senior engineer say this is overcomplicated?" If yes, simplify.

## 3. Surgical Changes

**Touch only what you must. Clean up only your own mess.**

When editing existing code:
- Don't "improve" adjacent code, comments, or formatting.
- Don't refactor things that aren't broken.
- Match existing style, even if you'd do it differently.
- If you notice unrelated dead code, mention it - don't delete it.

When your changes create orphans:
- Remove imports/variables/functions that YOUR changes made unused.
- Don't remove pre-existing dead code unless asked.

The test: Every changed line should trace directly to the user's request.

## 4. Goal-Driven Execution

**Define success criteria. Loop until verified.**

Transform tasks into verifiable goals:
- "Add validation" → "Write tests for invalid inputs, then make them pass"
- "Fix the bug" → "Write a test that reproduces it, then make it pass"
- "Refactor X" → "Ensure tests pass before and after"

For multi-step tasks, state a brief plan:
```
1. [Step] → verify: [check]
2. [Step] → verify: [check]
3. [Step] → verify: [check]
```

Strong success criteria let you loop independently. Weak criteria ("make it work") require constant clarification.

---

**These guidelines are working if:** fewer unnecessary changes in diffs, fewer rewrites due to overcomplication, and clarifying questions come before implementation rather than after mistakes.
