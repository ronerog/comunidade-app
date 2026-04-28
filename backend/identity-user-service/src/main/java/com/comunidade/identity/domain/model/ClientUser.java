package com.comunidade.identity.domain.model;

import java.time.LocalDate;

// TODO Fase 1: especialização de BaseUser para Cidadãos (RF01).
// Anotações sugeridas:
//   @Entity
//   @DiscriminatorValue("CLIENT")
//
// Campos específicos:
//   - firstName (String, not null)
//   - lastName  (String, not null)
//   - birthDate (LocalDate)
//   - gender    (Gender, @Enumerated(EnumType.STRING))
public class ClientUser extends BaseUser {

    // TODO: implementar
}
