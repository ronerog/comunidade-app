package com.comunidade.gateway.config;

import org.springframework.context.annotation.Configuration;

// TODO Fase 7: configurar Spring Security no Gateway (WebFlux / reactivo).
//
// ATENÇÃO: Gateway usa WebFlux, não WebMVC. As APIs de configuração são diferentes:
//   - Não use HttpSecurity (WebMVC). Use ServerHttpSecurity (WebFlux).
//   - Não use SecurityFilterChain. Use SecurityWebFilterChain.
//
// Esqueleto (reactivo):
//
//   @Configuration
//   @EnableWebFluxSecurity
//   public class SecurityConfig {
//
//       @Bean
//       SecurityWebFilterChain filterChain(ServerHttpSecurity http) {
//           return http
//               .csrf(csrf -> csrf.disable())
//               .cors(Customizer.withDefaults())
//               .authorizeExchange(auth -> auth
//                   // Registro é público
//                   .pathMatchers(POST, "/api/v1/users/clients").permitAll()
//                   .pathMatchers(POST, "/api/v1/users/providers").permitAll()
//                   // Vitrine pública (GET)
//                   .pathMatchers(GET, "/api/v1/services/**").permitAll()
//                   // Todo o resto precisa de autenticação
//                   .anyExchange().authenticated()
//               )
//               .oauth2ResourceServer(o -> o
//                   .jwt(Customizer.withDefaults())
//               )
//               .build();
//       }
//   }
//
// Rate Limiting (Fase 7):
//   Adicione o filtro RequestRateLimiter no application.yml por rota, ou aqui via código.
//   O Spring Cloud Gateway já tem o RequestRateLimiterGatewayFilter integrado com Redis.
//   Configure RateLimiter bean (RedisRateLimiter) com replenishRate e burstCapacity.
@Configuration
public class SecurityConfig {

    // TODO Fase 7: implementar SecurityWebFilterChain
}
