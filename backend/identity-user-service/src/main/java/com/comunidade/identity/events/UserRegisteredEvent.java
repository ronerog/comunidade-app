package com.comunidade.identity.events;

import java.time.LocalDateTime;
import java.util.UUID;

// TODO Fase 3: contrato do evento publicado quando um usuário se cadastra.
//
// Princípios de eventos de integração:
//   - INCLUA tudo que o consumidor precisa para tomar decisão SEM consultar você de volta.
//     Senão você cria acoplamento forte (e callback síncrono), matando a vantagem do async.
//   - NÃO inclua dados sensíveis (passwordHash, document completo).
//   - VERSIONE o contrato. Se o campo `name` virar `fullName`, é breaking change para
//     todos os consumidores. Considere adicionar `version` no payload ou na exchange.
//
// Campos sugeridos:
public record UserRegisteredEvent(
        // UUID userId,
        // String email,
        // String name,            // firstName + lastName (Client) OU companyName (Provider)
        // String userType,        // "CLIENT" ou "PROVIDER"
        // LocalDateTime createdAt
) {
}
