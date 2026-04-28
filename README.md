# Plataforma: Serviço Comunitário sob Demanda

Bem-vindo ao repositório base da **Plataforma Serviço Comunitário sob Demanda**. Este é um projeto focado em solidariedade cruzada, servindo como uma solução digital que conecta cidadãos necessitados com o fortalecimento de laços sociais por meio de redes de voluntariado e doação de serviços.

> Aviso Educacional: Este é um projeto acadêmico vinculado à **Faculdade CESMAC**. O repositório está sendo mantido sob auxílio de um Orquestrador de Agentes de IA (`.gemini/rules.md`) para fins de aprendizado de arquiteturas corporativas.
---

## Estrutura do Monorepo

O sistema adota uma topologia robusta em Microserviços padronizados com uso do `Gateway` e centralização de identidades de acesso (SSO Keycloak). Todas as camadas estão separadas neste Monorepo:

```text
/comunidade-app
├── /backend                    - Todos os serviços Java/Spring Boot
│   ├── api-gateway             [Roteador REST e Guardião de Entrada]
│   ├── identity-user-service   [Gestão dos Cidadãos e Usuários Prestadores]
│   └── service-catalog         [Catálogo das Disponibilidades de Voluntariados]
├── /frontend                   - Aplicação React / Next.js
├── /infra                      - Subida de contêineres vitais (Postgres, Keycloak, Docker-compose)
├── /docs                       - Documentos de Regras de Negócios (Mermaid, UML e RFs/RNFs)
└── /context                    - Recortes com a pesquisa material e originária da regra de negócios
```

## Stack Tecnológica

O projeto tira proveito de tecnologias essenciais para sistemas corporativos flexíveis:
- **Java 17+** & **Spring Boot 3** *(Microserviços, Spring Data JPA)*
- **Keycloak** *(SSO, JSON Web Tokens / OIDC, Políticas Estritas de Segurança)*
- **PostgreSQL** *(Persistência relacional isolada por domínios)*
- **Next.js & React** *(Interface Web interativa e otimização rica esteticamente)*
- **Docker Compose** *(Ambiente de Orquestração Local)*

## Documentação (Docs Base)

Caso deseje entender a fundo os fluxos de Cidadão, Prestador e Cadastros, confira em nossa pasta detalhada `docs/`. Lá encontram-se:
- [1. Visão de Arquitetura](./docs/1-arquitetura.md)
- [2. Especificação Funcional (RFs)](./docs/2-especificacoes_funcionalidades.md)
- [3. Modelo Entidade Relacionamento (MER)](./docs/3-modelo_entidade_relacionamento.md)
- [4. Mapeamento de Classes e Pacotes](./docs/4-mapeamento_de_classes.md)

---
*README mantido sob supervisão ativa do Orquestrador Gemini e da Suíte de Agentes (`@Documentor`).*
