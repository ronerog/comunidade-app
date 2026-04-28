package com.comunidade.identity.api.dto;

// TODO Fase 1: payload de cadastro de Prestador (RF02).
// Diferenças vs Cliente:
//   - companyName (quando CNPJ)
//   - document pode ser CPF OU CNPJ (validação custom)
//   - biography (resumo de habilidades)
//   - categories (lista de IDs de categorias)
public record RegisterProviderRequest(
        // TODO: campos
) {
}
