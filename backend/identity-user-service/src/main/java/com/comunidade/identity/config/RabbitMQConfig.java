package com.comunidade.identity.config;

import org.springframework.context.annotation.Configuration;

// TODO Fase 3: configurar a infraestrutura de mensageria do lado PUBLISHER.
//
// Constantes (você pode declarar aqui ou num enum/interface compartilhada):
//   public static final String USER_EXCHANGE     = "user.events";
//   public static final String USER_REGISTERED_Q = "user.registered.queue";
//   public static final String ROUTING_REGISTERED = "user.registered";
//
// Beans necessários:
//   1. TopicExchange — `new TopicExchange(USER_EXCHANGE, durable=true, autoDelete=false)`.
//   2. Queue         — `new Queue(USER_REGISTERED_Q, durable=true)`.
//      → Mesmo o publisher declara para garantir que existe no boot.
//   3. Binding       — liga Queue à Exchange com routing key.
//   4. MessageConverter (Jackson2JsonMessageConverter) — para serializar Java records em JSON.
//   5. RabbitTemplate (com o converter acima injetado).
//
// Conceito-chave (estuda isso):
//   Exchange    = roteador de mensagens (Topic faz match por routing key com wildcards).
//   Queue       = fila onde mensagens descansam até consumo.
//   Binding     = regra "essa exchange entrega nessa queue se a routing key bater X".
//   RoutingKey  = string que decide o roteamento. Padrão: "domain.action" (user.registered).
//
// Fase 4 (DLQ): você vai adicionar:
//   - dead-letter exchange (USER_EXCHANGE + ".dlx")
//   - dead-letter queue
//   - argumentos `x-dead-letter-exchange` na queue principal
//   - retry com TTL e re-publicação na queue principal após delay.
@Configuration
public class RabbitMQConfig {

    // TODO Fase 3: implementar beans

}
