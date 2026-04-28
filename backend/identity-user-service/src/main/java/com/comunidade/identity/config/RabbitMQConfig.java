package com.comunidade.identity.config;

import org.springframework.context.annotation.Configuration;

// TODO: Configurar o RabbitMQ
// Dicas do que você vai precisar:
// - TopicExchange (exchange principal de eventos de usuário)
// - Queue (fila para "user.registered")
// - Binding (ligar a fila à exchange com uma routing key)
// - MessageConverter com Jackson2JsonMessageConverter (serialização JSON)
// - RabbitTemplate com o converter acima
@Configuration
public class RabbitMQConfig {

}
