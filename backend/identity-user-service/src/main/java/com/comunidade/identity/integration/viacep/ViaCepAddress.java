package com.comunidade.identity.integration.viacep;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO Fase 6: DTO que espelha o JSON retornado pelo ViaCEP.
// Exemplo de resposta da API:
//   {
//     "cep": "01001-000",
//     "logradouro": "Praça da Sé",
//     "complemento": "lado ímpar",
//     "bairro": "Sé",
//     "localidade": "São Paulo",
//     "uf": "SP",
//     ...
//   }
//
// Usamos record + @JsonProperty para mapear nomes que não casam com convenção Java.
public record ViaCepAddress(
        // TODO: declarar campos
        // String cep,
        // String logradouro,
        // String bairro,
        // @JsonProperty("localidade") String city,
        // @JsonProperty("uf") String state
) {
}
