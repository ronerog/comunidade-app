package com.comunidade.catalog.api.dto;

import java.util.List;

// TODO Fase 1: payload de criação de serviço (RF03).
// Validações:
//   - title: @NotBlank, @Size(max=255)
//   - description: @NotBlank
//   - categoryId: @NotNull
//   - photoUrls: lista opcional, @Size(max=10)
public record CreateServiceRequest(
        // String title,
        // String description,
        // String availability,
        // Long categoryId,
        // List<String> photoUrls
) {
}
