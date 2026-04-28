package com.comunidade.catalog.domain.model;

import java.util.UUID;

// TODO: Mapear a entidade ProviderProfile com JPA (@Entity, @Table)
// Campos do MER: user_id (UUID, PK e FK 1:1 com Users do identity-service), biography (String)
// Relações: possui lista de ServiceItem (@OneToMany)
// Referência: docs/3-modelo_entidade_relacionamento.md — tabela PROVIDER_PROFILES
//             docs/4-mapeamento_de_classes.md — classe ProviderProfile
public class ProviderProfile {

    // TODO: userId (UUID, @Id — não gerado aqui, vem do identity-service)
    // TODO: biography (String)
    // TODO: services (List<ServiceItem>, @OneToMany)
}
