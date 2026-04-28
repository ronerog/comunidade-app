package com.comunidade.notification.consumer;

import com.comunidade.notification.events.UserRegisteredEvent;
import org.springframework.stereotype.Component;

// TODO: Ouvir a fila "user.registered" com @RabbitListener
// Ao receber o evento, delegar o envio de e-mail para o EmailService
@Component
public class UserRegisteredConsumer {

    // TODO: injetar o EmailService

    // TODO: criar o método listener anotado com @RabbitListener(queues = "user.registered")
    // O Spring vai desserializar a mensagem automaticamente para UserRegisteredEvent
}
