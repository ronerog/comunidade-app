package com.comunidade.identity.api.dto;

// TODO Fase 1: DTO de endereço, usado dentro de RegisterClientRequest e RegisterProviderRequest.
// Apenas o CEP costuma ser obrigatório no input — o resto vem do ViaCEP (Fase 6).
public record AddressDto(
        // TODO: cep, logradouro, number, bairro, city, state
) {
}
