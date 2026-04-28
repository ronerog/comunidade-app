package com.comunidade.identity.events;

import java.time.LocalDateTime;

// TODO: Definir os campos do evento que será publicado no RabbitMQ
// Este record representa o contrato da mensagem enviada ao notification-service
// Campos sugeridos: userId, email, name, createdAt
public record UserRegisteredEvent() {

}
