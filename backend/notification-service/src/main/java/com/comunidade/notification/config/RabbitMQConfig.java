package com.comunidade.notification.config;

import org.springframework.context.annotation.Configuration;

// TODO Fase 3: configurar a infraestrutura do lado CONSUMIDOR.
//
// Diferença importante vs o publisher:
//   - O consumidor SÓ precisa declarar a Queue (idempotente — se já existir, ignora).
//   - Não precisa declarar a Exchange nem o Binding (o publisher faz isso).
//   - MAS é boa prática declarar mesmo assim, para que o serviço suba mesmo se for
//     o primeiro a iniciar (resiliência).
//
// Constantes (devem casar com as do publisher!):
//   public static final String USER_REGISTERED_Q = "user.registered.queue";
//
// Beans:
//   1. Queue user.registered.queue (durable=true).
//   2. Jackson2JsonMessageConverter — para desserializar JSON em UserRegisteredEvent.
//   3. SimpleRabbitListenerContainerFactory com o converter — necessário para que
//      @RabbitListener consiga deserializar para o tipo do parâmetro.
//
// Esqueleto:
//
//   @Bean
//   public Jackson2JsonMessageConverter messageConverter() {
//       return new Jackson2JsonMessageConverter();
//   }
//
//   @Bean
//   public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(
//           ConnectionFactory cf, Jackson2JsonMessageConverter converter) {
//       SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//       factory.setConnectionFactory(cf);
//       factory.setMessageConverter(converter);
//       return factory;
//   }
//
// Fase 4 (DLQ): adicionar configuração de retry com BackOff exponencial e DLQ.
//   factory.setAdviceChain(RetryInterceptorBuilder...);
@Configuration
public class RabbitMQConfig {

    // TODO Fase 3: implementar
}
