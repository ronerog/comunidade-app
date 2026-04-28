package com.comunidade.catalog.config;

import org.springframework.context.annotation.Configuration;

// TODO Fase 3: o catalog é publisher E consumer.
//
// PUBLISHER — quando um serviço é criado/atualizado:
//   Constantes:
//     public static final String SERVICE_EXCHANGE = "service.events";
//     public static final String ROUTING_PUBLISHED = "service.published";
//
//   Beans:
//     - TopicExchange "service.events"
//     - Queue "service.published.queue" (para o notification-service consumir)
//     - Binding
//     - Jackson2JsonMessageConverter
//     - RabbitTemplate
//
// CONSUMER — para reagir a user.registered (quando um PROVIDER se cadastra,
// criar automaticamente o ProviderProfile aqui no catalog):
//   - Queue "user.registered.catalog.queue" (fila SEPARADA da do notification —
//     cada consumer tem sua própria fila no padrão pub/sub).
//   - Binding na exchange "user.events" com routing key "user.registered".
//
// Conceito: múltiplos consumidores devem ter FILAS SEPARADAS bindadas na MESMA exchange.
// Se compartilhassem fila, RabbitMQ entrega round-robin (cada msg vai pra UM consumer).
// Com filas separadas, cada uma recebe TODA mensagem que matchar a routing key (pub/sub).
@Configuration
public class RabbitMQConfig {

    // TODO Fase 3: implementar publisher beans + consumer queue + binding
}
