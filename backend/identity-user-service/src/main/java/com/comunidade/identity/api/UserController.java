package com.comunidade.identity.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO Fase 1: endpoints de usuário (cidadãos e prestadores).
// Versionamento: usamos /api/v1/... desde o começo (evita dor de cabeça depois).
//
// Endpoints sugeridos:
//   POST /api/v1/users/clients     -> registra cliente (RF01)        — público (não autenticado)
//   POST /api/v1/users/providers   -> registra prestador (RF02)      — público
//   GET  /api/v1/users/me          -> dados do usuário logado        — autenticado (JWT)
//   GET  /api/v1/users/{id}        -> dados de um usuário            — autenticado
//
// Boas práticas:
//   - Use @Valid no @RequestBody para disparar Bean Validation
//   - Use ResponseEntity<UserResponse> para controlar status HTTP (201 Created no POST)
//   - Use @AuthenticationPrincipal Jwt jwt para acessar o token (Fase 2)
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    // TODO: injetar UserRegistrationService e UserQueryService

    // TODO: implementar endpoints
}
