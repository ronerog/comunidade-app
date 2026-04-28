package com.comunidade.catalog.config;

import org.springframework.context.annotation.Configuration;

// TODO Fase 2: configurar Resource Server (idêntico em conceito ao do identity).
//
// Diferença importante: regras de autorização específicas do catálogo.
//
// Padrão sugerido:
//   GET  /api/v1/services            -> público (vitrine)
//   GET  /api/v1/services/**         -> público
//   POST /api/v1/services            -> autenticado COM role PROVIDER
//   PUT  /api/v1/services/{id}       -> autenticado COM role PROVIDER e dono do serviço
//   DELETE /api/v1/services/{id}     -> autenticado COM role PROVIDER e dono
//
// O check "dono do serviço" é típico — chamado de Method Security:
//   @PreAuthorize("@catalogSecurity.isOwner(authentication, #id)")
//
// Habilite com @EnableMethodSecurity na configuração.
@Configuration
public class SecurityConfig {

    // TODO Fase 2: implementar SecurityFilterChain e regras de autorização
}
