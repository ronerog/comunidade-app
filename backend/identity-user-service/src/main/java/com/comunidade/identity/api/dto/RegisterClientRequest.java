package com.comunidade.identity.api.dto;

import java.time.LocalDate;

// TODO Fase 1: definir o payload de cadastro de Cliente (RF01).
// Use Bean Validation para deixar a validação declarativa:
//   - @NotBlank, @Email no email
//   - @CPF (Hibernate Validator) no document
//   - @Pattern para senha forte (mín. 8, 1 maiúscula, 1 número, 1 especial)
//   - @NotNull no birthDate
//
// Padrão record é ótimo para DTOs imutáveis em Java 21.
public record RegisterClientRequest(
        // TODO: declarar campos com @NotBlank/@NotNull/@Email/@Pattern conforme RF01
) {
}
