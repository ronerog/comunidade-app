package com.comunidade.notification.config;

import org.springframework.context.annotation.Configuration;

// TODO: Configurar o RabbitMQ (lado consumidor)
// Dica: este serviço só consome, não precisa declarar a exchange novamente
// Declare apenas a Queue com o mesmo nome usado pelo publisher
// Configure o MessageConverter com Jackson2JsonMessageConverter
@Configuration
public class RabbitMQConfig {

}
