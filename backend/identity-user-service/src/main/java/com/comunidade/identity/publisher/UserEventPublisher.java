package com.comunidade.identity.publisher;

import com.comunidade.identity.events.UserRegisteredEvent;
import org.springframework.stereotype.Component;

// TODO: Injetar o RabbitTemplate e publicar o UserRegisteredEvent
// Dica: rabbitTemplate.convertAndSend(exchange, routingKey, event)
@Component
public class UserEventPublisher {

    // TODO: injetar RabbitTemplate via construtor (use @RequiredArgsConstructor do Lombok)

    public void publishUserRegistered(UserRegisteredEvent event) {
        // TODO: publicar o evento na exchange correta com a routing key "user.registered"
    }
}
