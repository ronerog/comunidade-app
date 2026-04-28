package com.comunidade.catalog.config;

import org.springframework.context.annotation.Configuration;

// TODO: Configurar RabbitMQ para o serviço de catálogo
// O catálogo pode publicar eventos como "service.created" ou "service.updated"
// para que outros serviços (como o de busca ou notificações) saibam da mudança.
@Configuration
public class RabbitMQConfig {

}
