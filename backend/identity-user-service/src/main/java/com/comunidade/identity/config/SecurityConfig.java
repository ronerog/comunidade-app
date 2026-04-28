package com.comunidade.identity.config;

import org.springframework.context.annotation.Configuration;

// TODO Fase 2: configurar Spring Security como Resource Server OAuth2.
//
// Conceitos que você vai aprender aqui:
//   1. SecurityFilterChain (substituiu o WebSecurityConfigurerAdapter, deprecated em Spring Security 6).
//   2. JWT validation: o `spring-boot-starter-oauth2-resource-server` valida o token LOCALMENTE
//      usando a chave pública (JWKS) que ele baixa do issuer-uri (definido em application.properties).
//      → Não há chamada ao Keycloak por request. É stateless e rápido.
//   3. Claim mapping: extrair roles/authorities do JWT (Keycloak coloca em `realm_access.roles`).
//   4. CORS: configurar origens permitidas para o frontend Next.js (http://localhost:3000).
//   5. Rotas públicas vs autenticadas (.permitAll vs .authenticated()).
//
// Esqueleto sugerido:
//
//   @Configuration
//   @EnableWebSecurity
//   public class SecurityConfig {
//
//       @Bean
//       SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//           http
//               .csrf(csrf -> csrf.disable())                       // API stateless, sem CSRF
//               .cors(Customizer.withDefaults())                    // habilita CORS bean abaixo
//               .sessionManagement(s -> s.sessionCreationPolicy(STATELESS))
//               .authorizeHttpRequests(auth -> auth
//                   .requestMatchers("/api/v1/users/clients", "/api/v1/users/providers").permitAll()
//                   .requestMatchers("/actuator/health").permitAll()
//                   .anyRequest().authenticated()
//               )
//               .oauth2ResourceServer(o -> o.jwt(jwt -> jwt
//                   .jwtAuthenticationConverter(keycloakJwtConverter())   // mapper de roles
//               ));
//           return http.build();
//       }
//
//       // TODO: bean keycloakJwtConverter() que extrai realm_access.roles e mapeia
//       //       para SimpleGrantedAuthority com prefixo ROLE_
//
//       // TODO: bean CorsConfigurationSource permitindo http://localhost:3000
//   }
@Configuration
public class SecurityConfig {

    // TODO Fase 2: implementar SecurityFilterChain
}
