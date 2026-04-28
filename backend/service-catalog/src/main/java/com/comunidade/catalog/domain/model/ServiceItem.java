package com.comunidade.catalog.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

// TODO: Mapear a entidade ServiceItem com JPA (@Entity, @Table(name = "services"))
// Campos do MER: id (UUID), provider_id (UUID, FK), category_id (Long, FK),
//                title, description, availability, status, created_at
// Relações:
//   - @ManyToOne com ProviderProfile (provider)
//   - @ManyToOne com Category (category)
//   - @OneToMany com ServicePhoto (photos)
// Referência: docs/3-modelo_entidade_relacionamento.md — tabela SERVICES
//             docs/4-mapeamento_de_classes.md — classe ServiceItem
public class ServiceItem {

    // TODO: id (UUID, @Id @GeneratedValue)
    // TODO: title (String)
    // TODO: description (String, @Column(columnDefinition = "TEXT"))
    // TODO: availability (String)
    // TODO: status (ServiceStatus enum)
    // TODO: createdAt (LocalDateTime)
    // TODO: provider (@ManyToOne ProviderProfile)
    // TODO: category (@ManyToOne Category)
    // TODO: photos (List<ServicePhoto>, @OneToMany)
}
