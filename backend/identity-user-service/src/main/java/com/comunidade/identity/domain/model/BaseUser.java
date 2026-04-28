package com.comunidade.identity.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

// TODO Fase 1: mapear como entidade JPA usando Single Table Inheritance
// Anotações sugeridas:
//   @Entity
//   @Table(name = "users")
//   @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//   @DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
//   @Getter @Setter (Lombok)
//
// Campos do MER (docs/3-modelo_entidade_relacionamento.md tabela USERS):
//   - id (UUID, @Id @GeneratedValue(strategy = GenerationType.UUID))
//   - email (String, único, not null)
//   - passwordHash (String, not null)            // mesmo com Keycloak, manter? decida na Fase 2
//   - document (String, único — CPF ou CNPJ)
//   - mobilePhone (String)
//   - profilePictureUrl (String)
//   - documentAnexUrl (String)
//   - status (UserStatus, @Enumerated(EnumType.STRING))
//   - createdAt (LocalDateTime, @CreationTimestamp ou @PrePersist)
//   - updatedAt (LocalDateTime, @UpdateTimestamp ou @PreUpdate)
//   - address (Address, @OneToOne(cascade = ALL, orphanRemoval = true))
//
// Dica de aprendizado: na Fase 2 (Keycloak) você vai decidir se mantém passwordHash aqui
// ou se delega TODA autenticação ao Keycloak (recomendado). Se delegar, este campo some
// e o `id` daqui passa a corresponder ao `sub` do JWT.
public abstract class BaseUser {

    // TODO: campos comuns aqui
}
