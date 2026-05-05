package com.comunidade.identity.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record RegisterProviderRequest(
        @NotBlank @Email
        String email,

        @NotBlank @Size(min = 8, message = "Senha deve ter no mínimo 8 caracteres")
        @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z\\d]).+$",
                 message = "Senha deve ter ao menos 1 maiúscula, 1 número e 1 caractere especial")
        String password,

        @NotBlank @Size(min = 11, max = 14, message = "Documento deve ser CPF (11) ou CNPJ (14)")
        String document,

        @Size(max = 255)
        String companyName,

        String biography,

        @Size(max = 20)
        String mobilePhone,

        @NotNull @Valid
        AddressDto address
) {
}
