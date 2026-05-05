-- ─────────────────────────────────────────────────────────────────────────────
-- Migration V1 — esquema inicial do Identity Service
-- ─────────────────────────────────────────────────────────────────────────────

CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE users (
    id                  UUID         PRIMARY KEY DEFAULT gen_random_uuid(),
    user_type           VARCHAR(20)  NOT NULL,                      -- discriminator: CLIENT | PROVIDER
    email               VARCHAR(255) NOT NULL UNIQUE,
    password_hash       VARCHAR(255),                               -- nullable: Fase 2 decide se Keycloak assume
    document            VARCHAR(20)  NOT NULL UNIQUE,               -- CPF ou CNPJ
    mobile_phone        VARCHAR(20),
    profile_picture_url VARCHAR(512),
    document_anex_url   VARCHAR(512),
    status              VARCHAR(20)  NOT NULL DEFAULT 'PENDING',    -- enum: PENDING | ACTIVE | BLOCKED
    -- campos específicos de CLIENT
    first_name          VARCHAR(100),
    last_name           VARCHAR(100),
    birth_date          DATE,
    gender              VARCHAR(10),                                -- enum: MALE | FEMALE | OTHER
    -- campos específicos de PROVIDER
    company_name        VARCHAR(255),
    biography           TEXT,
    created_at          TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at          TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE addresses (
    id         UUID         PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id    UUID         NOT NULL UNIQUE REFERENCES users(id) ON DELETE CASCADE,
    cep        VARCHAR(8)   NOT NULL,
    logradouro VARCHAR(255) NOT NULL,
    number     VARCHAR(20)  NOT NULL,
    bairro     VARCHAR(100) NOT NULL,
    city       VARCHAR(100) NOT NULL,
    state      VARCHAR(2)   NOT NULL
);

CREATE INDEX idx_users_status  ON users(status);
CREATE INDEX idx_addresses_cep ON addresses(cep);
