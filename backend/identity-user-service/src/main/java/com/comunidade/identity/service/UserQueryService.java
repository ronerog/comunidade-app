package com.comunidade.identity.service;

import org.springframework.stereotype.Service;

// TODO Fase 1 + Fase 5 (cache): consultas de usuário.
// Métodos sugeridos:
//   - UserResponse findById(UUID id);
//   - UserResponse findCurrent(Jwt principal);   // pega o sub do JWT (Fase 2)
//
// Fase 5: anote findById com @Cacheable("users") para cachear no Redis.
// Não esqueça de @CacheEvict no UserRegistrationService quando atualizar dados do usuário.
@Service
public class UserQueryService {

    // TODO: injetar UserRepository

    // TODO: implementar
}
