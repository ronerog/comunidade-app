package com.comunidade.notification.consumer;

import com.comunidade.notification.events.UserRegisteredEvent;
import org.springframework.stereotype.Component;

// TODO Fase 3: ouvinte da fila "user.registered.queue".
//
// Esqueleto:
//
//   @Component
//   @RequiredArgsConstructor
//   @Slf4j
//   public class UserRegisteredConsumer {
//
//       private final EmailService emailService;
//
//       @RabbitListener(queues = "user.registered.queue")
//       public void onUserRegistered(UserRegisteredEvent event) {
//           log.info("Recebido user.registered: userId={}, email={}", event.userId(), event.email());
//           emailService.sendWelcomeEmail(event.email(), event.name());
//       }
//   }
//
// Cuidados:
//   - IDEMPOTÊNCIA: o RabbitMQ pode entregar a mesma mensagem mais de uma vez
//     (em redelivery após erro). Se você enviar e-mail toda vez, o usuário recebe N e-mails.
//     Solução: armazenar (userId, eventType) já processados em Redis com TTL grande.
//     Antes de processar, checar; depois de processar, marcar.
//
//   - TRATAMENTO DE ERRO: se EmailService lançar exceção, o Spring re-entrega a mensagem
//     (até esgotar retries → vai pra DLQ na Fase 4). Não engula exceções aqui.
@Component
public class UserRegisteredConsumer {

    // TODO Fase 3: injetar EmailService e implementar listener
}
