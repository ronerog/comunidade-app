package com.comunidade.identity.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AddressDto(
        @NotBlank @Pattern(regexp = "\\d{8}", message = "CEP deve ter 8 dígitos sem máscara")
        String cep,

        @NotBlank
        String logradouro,

        @NotBlank @Size(max = 20)
        String number,

        @NotBlank @Size(max = 100)
        String bairro,

        @NotBlank @Size(max = 100)
        String city,

        @NotBlank @Size(min = 2, max = 2, message = "Estado deve ter 2 caracteres (ex: AL)")
        String state
) {
}
