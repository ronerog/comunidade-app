# Plataforma: Serviço Comunitário sob Demanda

Bem-vindo ao repositório base da **Plataforma Serviço Comunitário sob Demanda**. Este é um projeto focado em solidariedade cruzada, servindo como uma solução digital que conecta cidadãos necessitados com o fortalecimento de laços sociais por meio de redes de voluntariado e doação de serviços.

> Aviso Educacional: Este é um projeto acadêmico vinculado à **Faculdade CESMAC**. O repositório está sendo mantido sob auxílio de um Orquestrador de Agentes de IA para fins de aprendizado de arquiteturas corporativas.
---

## Estrutura do Monorepo

O sistema adota uma topologia robusta em Microserviços padronizados. Todas as camadas estão separadas neste Monorepo:

```text
/comunidade-app
├── /backend                    - Todos os serviços Java 21 / Spring Boot 3
│   ├── identity-user-service   [Gestão dos Cidadãos e Usuários Prestadores]
│   ├── service-catalog         [Catálogo das Disponibilidades de Voluntariados]
│   └── notification-service    [Motor de envio de e-mails e alertas assíncronos]
├── /frontend                   - Aplicação React / Next.js
├── /infra                      - Configuração de contêineres (PostgreSQL, RabbitMQ, Redis, Keycloak, Mailpit)
├── /docs                       - Documentos de Arquitetura e Regras de Negócios
└── /context                    - Recortes com a pesquisa material e originária da regra de negócios
```

## Stack Tecnológica

O projeto utiliza tecnologias modernas para sistemas distribuídos e resilientes:
- **Java 21** & **Spring Boot 3.4+** *(JPA, Security, AMQP)*
- **RabbitMQ** *(Message Broker para comunicação assíncrona)*
- **Redis** *(Cache distribuído e performance)*
- **Keycloak** *(Gestão de Identidade e Acessos - SSO)*
- **PostgreSQL** *(Persistência relacional por domínio)*
- **Mailpit** *(Servidor SMTP local para testes de e-mail)*
- **Next.js & React** *(Interface Web interativa)*
- **Docker Compose** *(Orquestração completa do ambiente local)*

## Documentação (Docs Base)

Para entender os fluxos de Cidadão, Prestador e a arquitetura detalhada, consulte:
- [1. Visão de Arquitetura](./docs/1-arquitetura.md)
- [2. Especificação Funcional (RFs)](./docs/2-especificacoes_funcionalidades.md)
- [3. Modelo Entidade Relacionamento (MER)](./docs/3-modelo_entidade_relacionamento.md)
- [4. Mapeamento de Classes e Pacotes](./docs/4-mapeamento_de_classes.md)

---
*README mantido sob supervisão ativa do Orquestrador Gemini e da Suíte de Agentes (`@Documentor`).*
