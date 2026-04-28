package com.comunidade.catalog.domain.model;

import java.util.UUID;

// TODO Fase 1: mapear ProviderProfile como entidade JPA.
//
// Anotações sugeridas:
//   @Entity
//   @Table(name = "provider_profiles")
//   @Getter @Setter
//
// Campos do MER (PROVIDER_PROFILES):
//   - userId    (UUID, @Id) -- vem do identity-service. NÃO use @GeneratedValue.
//   - biography (String, @Column(columnDefinition = "TEXT"))
//   - services  (List<ServiceItem>, @OneToMany(mappedBy = "provider", cascade = ALL))
//
// IMPORTANTE — quem cria o ProviderProfile?
//   Quando identity publica `user.registered` com userType=PROVIDER, o catalog
//   consome esse evento e cria o ProviderProfile aqui automaticamente.
//   → Você precisará criar um listener (Fase 3) e um ProviderProfileRepository (já existe).
public class ProviderProfile {

    // TODO: implementar
}
