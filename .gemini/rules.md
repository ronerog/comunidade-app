# AI Core Constitution (.gemini/rules.md)

Este é o arquivo normativo que rege o comportamento de todos os LLMs, IAs atuantes, Servidores MCP e Ferramentas automatizadas presentes neste repositório. O "Comunidade App" é um projeto estritamente voltado ao aprendizado.

## Orquestração de Agentes
1. **Modelos Unificados:** O Chat e Autocomplete são Inteligências Artificiais com múltiplas "Skills". A IA mapeará a intenção do desenvolvedor e atuará focada como um dos Agentes descritos na pasta `.gemini/skills/` (ex: Documentador, Spring Coder, NextJS Coder).
2. O Desenvolvedor **não é obrigado a invocar textualmente** os agentes (como `@Spring`). Apenas se expressar o pedido ("Faz o login") já engatilha na IA o contexto adequado, porém o DEV pode chamá-los para forçar o foco.

## Leis Fundamentais (NÃO QUEBRAR)

1. **PROIBIDO INJEÇÃO SILENCIOSA:** A IA está proscrita de adicionar novas bibliotecas (ex: Maven Repositories, NPM Packages), padrões complexos ou alterações de framework (ex: substituir JPA por JDBC manual) sem que antes explique detalhadamente a escolha e receba aval do Desenvolvedor.
2. **EDUCACIONAL PRIMEIRO:** Como o objetivo é o aprendizado de arquiteturas completas e microserviços orientados a eventos, todo e qualquer bloco considerável de código deve ser justificado através de comentários no código ou explanações no chat. 
3. **RESPEITO AO DOCUMENTO:** A IA nunca codificará Entidades de Banco de Dados ou Módulos que conflitem com as regras estipuladas em `./docs/`. Se houver divergências lógicas, a IA deve primeiro sugerir uma atualização da Documentação via `@Documentor Agent`.
4. **COMPAREMENTO ARQUITETURAL:** Os Microsserviços (`identity`, `catalog`) não podem se misturar diretamente pelo código. Comunicações devem ocorrer através de contratos de Redes/REST previstos ou Eventos, tudo passando por trás do API Gateway.
5. **RESTRIÇÃO DE EMOJIS:** É estritamente proibido o uso de emojis na documentação (Markdown), mensagens de Commit ou qualquer código gerado para este projeto. A linguagem deve se manter sóbria e acadêmica.
