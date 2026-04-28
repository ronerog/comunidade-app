package com.comunidade.catalog.domain.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

// TODO Fase 1: entidade central do catálogo (RF03).
//
// Anotações sugeridas:
//   @Entity
//   @Table(name = "services")
//   @Getter @Setter
//
// Campos do MER:
//   - id           (UUID, @Id @GeneratedValue(strategy = UUID))
//   - title        (String, @Column(nullable = false))
//   - description  (String, @Column(columnDefinition = "TEXT"))
//   - availability (String)
//   - status       (ServiceStatus, @Enumerated(EnumType.STRING))
//   - createdAt    (LocalDateTime, @CreationTimestamp)
//
// Relações:
//   - provider (@ManyToOne ProviderProfile, @JoinColumn(name = "provider_id"))
//   - category (@ManyToOne Category, @JoinColumn(name = "category_id"))
//   - photos   (@OneToMany(mappedBy = "service", cascade = ALL, orphanRemoval = true))
//
// Dica de performance: ManyToOne padrão é EAGER. Em produção, prefira LAZY (FetchType.LAZY)
// e use queries com JOIN FETCH onde precisar. Aprenda o "N+1 problem" — clássico do Hibernate.
public class ServiceItem {

    // TODO: implementar
}
