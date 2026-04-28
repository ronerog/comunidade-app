package com.comunidade.identity.service;

import org.springframework.stereotype.Service;

// TODO Fase 1: orquestração do cadastro de usuário (RF01 e RF02).
// Responsabilidades sugeridas:
//   1. Validar unicidade (email, document) — checar com o repositório.
//   2. Criar entidade ClientUser/ProviderUser a partir do DTO.
//   3. Buscar o endereço completo via ViaCepClient (Fase 6) usando o CEP.
//   4. Persistir.
//   5. Publicar evento user.registered (Fase 3) — DEPOIS do commit (use @TransactionalEventListener
//      ou publicar no final do método transacional).
//   6. Retornar UserResponse.
//
// Dica de aprendizado: marcar o método como @Transactional. Pesquise o que é "publicar evento
// dentro de transação" — é uma armadilha clássica em arquiteturas event-driven (outbox pattern).
@Service
public class UserRegistrationService {

    // TODO: injetar UserRepository, AddressRepository, ViaCepClient, UserEventPublisher, PasswordEncoder

    // TODO: registerClient(RegisterClientRequest req) -> UserResponse
    // TODO: registerProvider(RegisterProviderRequest req) -> UserResponse
}
