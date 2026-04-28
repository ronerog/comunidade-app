package com.comunidade.catalog.events;

import java.time.LocalDateTime;
import java.util.UUID;

// TODO Fase 3: ESPELHA o evento publicado pelo identity-service.
// Mesmo contrato do com.comunidade.identity.events.UserRegisteredEvent
// (e do com.comunidade.notification.events.UserRegisteredEvent).
//
// Quando um usuário do tipo PROVIDER se cadastra, este evento dispara
// a criação automática de ProviderProfile no catálogo.
public record UserRegisteredEvent(
        // UUID userId,
        // String email,
        // String name,
        // String userType,
        // LocalDateTime createdAt
) {
}
