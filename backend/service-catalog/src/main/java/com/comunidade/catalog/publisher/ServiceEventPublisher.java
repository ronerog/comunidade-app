package com.comunidade.catalog.publisher;

import com.comunidade.catalog.events.ServicePublishedEvent;
import org.springframework.stereotype.Component;

// TODO Fase 3: publica eventos da exchange "service.events".
// Mesma estrutura do UserEventPublisher do identity.
@Component
public class ServiceEventPublisher {

    // TODO: injetar RabbitTemplate

    public void publishServicePublished(ServicePublishedEvent event) {
        // TODO: rabbitTemplate.convertAndSend("service.events", "service.published", event)
    }
}
