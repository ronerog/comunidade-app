package com.comunidade.identity.publisher;

import com.comunidade.identity.events.UserRegisteredEvent;
import org.springframework.stereotype.Component;

// TODO Fase 3: publica eventos da exchange "user.events".
//
// Esqueleto:
//
//   @Component
//   @RequiredArgsConstructor   // Lombok injeta via construtor
//   public class UserEventPublisher {
//
//       private final RabbitTemplate rabbitTemplate;
//
//       public void publishUserRegistered(UserRegisteredEvent event) {
//           rabbitTemplate.convertAndSend(
//               RabbitMQConfig.USER_EXCHANGE,
//               RabbitMQConfig.ROUTING_REGISTERED,
//               event
//           );
//       }
//   }
//
// Cuidado importante (outbox pattern):
//   Se você publicar DENTRO de uma transação JPA e a transação der rollback,
//   o evento já foi publicado e o usuário NÃO foi criado — inconsistência.
//
// Soluções:
//   (a) Publicar APÓS o commit usando @TransactionalEventListener(phase = AFTER_COMMIT).
//   (b) Outbox pattern: gravar o evento numa tabela "outbox" na mesma transação,
//       e ter um job que lê dessa tabela e publica no Rabbit. Mais robusto.
//
// Para projeto acadêmico, (a) é suficiente. Mas estude (b) — é o padrão real de produção.
@Component
public class UserEventPublisher {

    // TODO Fase 3: injetar RabbitTemplate e implementar publishUserRegistered
}
