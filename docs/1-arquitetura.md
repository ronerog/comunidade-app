# Arquitetura do Sistema - Serviço Comunitário sob Demanda

## Visão Geral

A Plataforma é uma solução digital voltada ao fortalecimento de laços sociais através de voluntariado em rede. Ela conecta:
1. **Cidadãos** que necessitam de auxílio.
2. **Prestadores de Serviço (Voluntários)** que desejam ofertar destrezas gratuitamente.

A arquitetura base utiliza **Microsserviços**. Isso isola o "Catálogo de Serviços" do "Gerenciador de Usuários (Identity)", protegendo o banco e permitindo escalar de forma diferente (ex: o catálogo de serviços recebe muito mais leituras do que o serviço de cadastros).

## Pilha Tecnológica Principal
- **Frontend**: Aplicação SPA conectada via REST.
- **Integrações Externas**: Webservices públicos (ViaCEP) e possivelmente validadores de CPF/CNPJ.
- **Backend (Microsserviços)**: Ecossistema desenvolvido em **Java** + **Spring Boot**.
- **Autenticação e Gestão de Acessos**: Delegação segura utilizando o **Keycloak** (OIDC / OAuth2).
- **Comunicação Segura**: Centralizada através de um **API Gateway**.

---

## Diagrama da Arquitetura

O sistema é dividido em domínios core (Identidade vs. Catálogo).

```mermaid
flowchart TD
    %% Nós Externos
    ClientWeb([Frontend Plataforma])
    ViaCep([Webservice ViaCEP])

    %% Infraestrutura de Borda
    Gateway[API Gateway]
    Keycloak[Keycloak IAM]

    %% Microsserviços
    Identity[Identity Service (Auth & Users)]
    ServiceCatalog[Catalog Service (Vitrine)]

    %% Bases de Dados
    DBIdentity[(PostgreSQL - Users & Profiles)]
    DBCatalog[(PostgreSQL / MongoDB - Services)]

    %% Conexões Cliente -> Gateway -> Micro
    ClientWeb -->|OIDC Login| Keycloak
    ClientWeb -->|HTTP/REST (Bearer Token)| Gateway
    Gateway -->|Valida Token| Keycloak
    Gateway -->|/api/users| Identity
    Gateway -->|/api/services| ServiceCatalog

    Identity --> DBIdentity
    ServiceCatalog --> DBCatalog

    %% Comunicações e APIs externas
    Identity ..->|Integração Endereços| ViaCep

    classDef ms fill:#0d1117,stroke:#58a6ff,stroke-width:2px,color:#fff
    classDef infra fill:#21262d,stroke:#8b949e,stroke-width:2px,color:#fff
    classDef db fill:#0d1117,stroke:#3fb950,stroke-width:2px,color:#fff
    classDef ext fill:#1f6feb,stroke:#fff,stroke-width:2px,color:#fff

    class Identity,ServiceCatalog ms
    class DBIdentity,DBCatalog db
    class Gateway,ViaCep,Keycloak ext
```
