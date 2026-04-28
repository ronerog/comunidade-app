package com.comunidade.catalog.consumer;

import com.comunidade.catalog.events.UserRegisteredEvent;
import org.springframework.stereotype.Component;

// TODO Fase 3: cria ProviderProfile automaticamente ao receber user.registered
// quando userType == "PROVIDER".
//
// Esqueleto:
//
//   @Component
//   @RequiredArgsConstructor
//   public class UserRegisteredCatalogConsumer {
//
//       private final ProviderProfileRepository repo;
//
//       @RabbitListener(queues = "user.registered.catalog.queue")
//       public void handle(UserRegisteredEvent event) {
//           if (!"PROVIDER".equals(event.userType())) return;
//
//           if (repo.existsById(event.userId())) return;   // idempotência simples
//
//           ProviderProfile profile = new ProviderProfile();
//           profile.setUserId(event.userId());
//           // biography vem depois, no fluxo de "completar perfil"
//           repo.save(profile);
//       }
//   }
//
// Note como o catalog NÃO faz HTTP no identity para buscar dados do usuário.
// Ele recebe só o que precisa via evento — desacoplado.
@Component
public class UserRegisteredCatalogConsumer {

    // TODO Fase 3: implementar
}
