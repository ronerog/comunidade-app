package com.comunidade.identity.api.dto;

import java.util.UUID;

// TODO Fase 1: DTO de saída — nunca retorne a entidade JPA diretamente em endpoints REST.
// Por que? Evita lazy loading explodindo serialização, vazamento de campos sensíveis (passwordHash),
// e desacopla contrato HTTP de mudanças no banco.
public record UserResponse(
        // TODO: id (UUID), email, name (firstName + lastName ou companyName), status, createdAt
) {
}
