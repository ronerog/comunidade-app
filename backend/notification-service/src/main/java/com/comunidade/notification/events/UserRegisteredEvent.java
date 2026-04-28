package com.comunidade.notification.events;

import java.time.LocalDateTime;

// TODO: Espelhar os campos do UserRegisteredEvent publicado pelo identity-user-service
// Deve ter os mesmos campos para que o Jackson consiga desserializar a mensagem do RabbitMQ
public record UserRegisteredEvent() {

}
