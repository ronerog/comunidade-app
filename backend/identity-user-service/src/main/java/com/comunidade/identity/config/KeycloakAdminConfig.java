package com.comunidade.identity.config;

import org.springframework.context.annotation.Configuration;

// TODO Fase 2 (avançado): se você decidir que o cadastro cria o usuário NO KEYCLOAK
// (e não só no banco do Identity), vai precisar do Keycloak Admin Client.
//
// Cenário: usuário se cadastra → Identity Service:
//   1. valida dados
//   2. cria usuário no Keycloak via Admin REST API (recebe o `sub`/UUID do Keycloak)
//   3. salva no banco local SOMENTE os dados que o Keycloak não armazena
//      (CPF, foto, endereço, biography, status do RF, etc.)
//   4. envia e-mail de ativação (via Keycloak send-email-action ou nosso próprio fluxo)
//
// Discussão importante: onde mora cada dado?
//   - Keycloak: email, password, firstName, lastName, "sub" (UUID), confirmação de email
//   - Identity DB: CPF, telefone, endereço, fotos, status RF, gênero, data nascimento, biography
//
// Documente sua decisão antes de implementar.
//
// Dependências para adicionar quando for implementar:
//   <dependency>
//       <groupId>org.keycloak</groupId>
//       <artifactId>keycloak-admin-client</artifactId>
//       <version>26.0.0</version>
//   </dependency>
@Configuration
public class KeycloakAdminConfig {

    // TODO Fase 2: bean Keycloak (admin client) com URL, realm, clientId, clientSecret
    // injetados via @Value de propriedades em application.properties:
    //   keycloak.admin.server-url
    //   keycloak.admin.realm
    //   keycloak.admin.client-id
    //   keycloak.admin.client-secret
}
