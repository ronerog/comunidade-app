package com.comunidade.catalog.domain.model;

import java.util.UUID;

// TODO: Mapear a entidade ServicePhoto com JPA (@Entity, @Table(name = "service_photos"))
// Campos do MER: id (UUID), service_id (UUID, FK), photo_url (String)
// Relação: @ManyToOne com ServiceItem
// Referência: docs/3-modelo_entidade_relacionamento.md — tabela SERVICE_PHOTOS
public class ServicePhoto {

    // TODO: id (UUID, @Id @GeneratedValue)
    // TODO: photoUrl (String)
    // TODO: service (@ManyToOne ServiceItem)
}
