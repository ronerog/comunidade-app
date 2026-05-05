package com.comunidade.identity.api.dto;

import com.comunidade.identity.domain.model.Gender;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record RegisterClientRequest(
        @NotBlank @Email
        String email,

        @NotBlank @Size(min = 8, message = "Senha deve ter no mínimo 8 caracteres")
        @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z\\d]).+$",
                 message = "Senha deve ter ao menos 1 maiúscula, 1 número e 1 caractere especial")
        String password,

        @NotBlank @Size(min = 11, max = 11, message = "CPF deve ter 11 dígitos")
        String document,

        @NotBlank @Size(max = 100)
        String firstName,

        @NotBlank @Size(max = 100)
        String lastName,

        @NotNull
        LocalDate birthDate,

        Gender gender,

        @Size(max = 20)
        String mobilePhone,

        @NotNull @Valid
        AddressDto address
) {
}
