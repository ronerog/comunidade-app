package com.comunidade.gateway.config;

import org.springframework.context.annotation.Configuration;

// TODO Fase 7: configurar rate limiting por IP (ou por usuário autenticado).
//
// Spring Cloud Gateway tem suporte nativo via Redis:
//   - RedisRateLimiter: implementa token bucket (replenishRate tokens/seg, burst até burstCapacity)
//   - KeyResolver: define a "chave" de agrupamento (por IP, por userId, por API key...)
//
// Esqueleto:
//
//   @Configuration
//   public class RateLimitConfig {
//
//       // Rate limiter: 10 req/s, burst de até 20
//       @Bean
//       public RedisRateLimiter redisRateLimiter() {
//           return new RedisRateLimiter(10, 20, 1);
//       }
//
//       // Por IP (anônimos) — muda para JWT subject em rotas autenticadas
//       @Bean
//       @Primary
//       public KeyResolver ipKeyResolver() {
//           return exchange -> Mono.just(
//               exchange.getRequest().getRemoteAddress().getAddress().getHostAddress()
//           );
//       }
//   }
//
// E no application.yml, adicione nos filters de cada rota:
//   - name: RequestRateLimiter
//     args:
//       redis-rate-limiter: "#{@redisRateLimiter}"
//       key-resolver: "#{@ipKeyResolver}"
@Configuration
public class RateLimitConfig {

    // TODO Fase 7: implementar beans de rate limiting
}
