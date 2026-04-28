# Arquitetura do Sistema - Serviço Comunitário sob Demanda

## Visão Geral

A Plataforma é uma solução digital voltada ao fortalecimento de laços sociais através de voluntariado em rede. Ela conecta:
1. **Cidadãos** que necessitam de auxílio.
2. **Prestadores de Serviço (Voluntários)** que desejam ofertar destrezas gratuitamente.

A arquitetura base utiliza **Microsserviços**. Isso isola o "Catálogo de Serviços" do "Gerenciador de Usuários (Identity)", protegendo o banco e permitindo escalar de forma diferente (ex: o catálogo de serviços recebe muito mais leituras do que o serviço de cadastros). Recentemente, foi adicionado um **Serviço de Notificação** para lidar com comunicações assíncronas (e-mails) disparadas por eventos do sistema.

## Pilha Tecnológica Principal
- **Frontend**: Aplicação SPA (React/Next.js) conectada via REST.
- **Integrações Externas**: Webservices públicos (ViaCEP) e servidores SMTP (Mailpit em desenvolvimento).
- **Backend (Microsserviços)**: Ecossistema desenvolvido em **Java 21** + **Spring Boot 3.4+**.
- **Autenticação e Gestão de Acessos**: Delegação segura utilizando o **Keycloak** (OIDC / OAuth2).
- **Comunicação Segura**: Centralizada através de um **API Gateway**.
- **Mensageria**: **RabbitMQ** para comunicação assíncrona baseada em eventos (Pub/Sub).
- **Cache e Performance**: **Redis** para cache de sessões, perfis e blacklist de tokens.

---

## Diagrama da Arquitetura

O sistema é dividido em domínios core (Identidade vs. Catálogo) e serviços de suporte (Notificação).

```mermaid
flowchart TD
    %% Nós Externos
    ClientWeb([Frontend Plataforma])
    ViaCep([Webservice ViaCEP])
    Smtp([Servidor SMTP / Mailpit])

    %% Infraestrutura de Borda e Suporte
    Gateway[API Gateway]
    Keycloak[Keycloak IAM]
    Broker[RabbitMQ Message Broker]
    Cache[(Redis Cache)]

    %% Microsserviços
    Identity[Identity Service (Auth & Users)]
    ServiceCatalog[Catalog Service (Vitrine)]
    Notification[Notification Service]

    %% Bases de Dados
    DBIdentity[(PostgreSQL - Users & Profiles)]
    DBCatalog[(PostgreSQL - Services)]

    %% Conexões Cliente -> Gateway -> Micro
    ClientWeb -->|OIDC Login| Keycloak
    ClientWeb -->|HTTP/REST (Bearer Token)| Gateway
    Gateway -->|Valida Token| Keycloak
    Gateway -->|/api/users| Identity
    Gateway -->|/api/services| ServiceCatalog
    Gateway -->|/api/notif| Notification

    %% Fluxos Internos e Infra
    Identity --> DBIdentity
    ServiceCatalog --> DBCatalog
    
    Identity <--> Cache
    ServiceCatalog <--> Cache
    
    %% Mensageria (Eventos)
    Identity -- "Publica: user.registered" --> Broker
    ServiceCatalog -- "Publica: service.published" --> Broker
    Broker -- "Consome eventos" --> Notification
    
    Notification --> Smtp

    %% Conexões Externas
    Identity ..->|Integração Endereços| ViaCep

    classDef ms fill:#0d1117,stroke:#58a6ff,stroke-width:2px,color:#fff
    classDef infra fill:#21262d,stroke:#8b949e,stroke-width:2px,color:#fff
    classDef db fill:#0d1117,stroke:#3fb950,stroke-width:2px,color:#fff
    classDef ext fill:#1f6feb,stroke:#fff,stroke-width:2px,color:#fff

    class Identity,ServiceCatalog,Notification ms
    class DBIdentity,DBCatalog db
    class Gateway,ViaCep,Keycloak,Broker,Cache,Smtp ext
```
