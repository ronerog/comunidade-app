package com.comunidade.notification.events;

import java.time.LocalDateTime;
import java.util.UUID;

// TODO Fase 3: ESPELHAR exatamente os campos publicados pelo identity-user-service.
//
// IMPORTANTE: este record deve ter o MESMO formato do
// com.comunidade.identity.events.UserRegisteredEvent — Jackson desserializa
// pelos NOMES dos campos. Se um lado tiver `name` e o outro `fullName`,
// vai falhar silenciosamente (campo fica null).
//
// Estratégia futura para evitar drift:
//   - Criar um módulo `comunidade-events` (Maven module compartilhado) com os
//     records. Os dois serviços importam o mesmo JAR. Mais robusto que duplicar.
//   - Ou usar Avro/Protobuf com schema registry. Overkill para este projeto.
public record UserRegisteredEvent(
        // UUID userId,
        // String email,
        // String name,
        // String userType,
        // LocalDateTime createdAt
) {
}
