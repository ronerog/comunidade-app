package com.comunidade.identity.domain.model;

import java.util.UUID;

// TODO Fase 1: mapear endereço (1:1 com BaseUser).
// Anotações sugeridas:
//   @Entity
//   @Table(name = "addresses")
//   @Getter @Setter
//
// Campos do MER (tabela ADDRESSES):
//   - id          (UUID, @Id @GeneratedValue)
//   - cep         (String, 8 dígitos sem máscara)
//   - logradouro  (String)
//   - number      (String) — string porque pode ser "S/N", "100A", etc.
//   - bairro      (String)
//   - city        (String)
//   - state       (String, 2 chars)
//
// Dica: o lado dono da relação (que carrega o FK) costuma ser Address (com user_id),
// mas para 1:1 dá pra inverter. Decida e justifique.
public class Address {

    // TODO: implementar
}
