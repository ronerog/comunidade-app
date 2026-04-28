package com.comunidade.identity.config;

import org.springframework.context.annotation.Configuration;

// TODO Fase 5: configurar Redis para cache de leitura.
//
// Beans necessários:
//   1. @EnableCaching na classe — habilita @Cacheable/@CacheEvict no projeto.
//   2. RedisCacheManager — define TTL padrão e por nome de cache.
//   3. (opcional) RedisTemplate<String, Object> — para operações manuais
//      (ex: blacklist de tokens, contadores, locks distribuídos).
//
// Decisões pedagógicas:
//   - TTL por cache: viacep pode ter TTL longo (24h), users perfil curto (5min),
//     listas que mudam pouco (10min). Pense ANTES de implementar.
//   - Serializador: GenericJackson2JsonRedisSerializer permite ler o cache fora
//     da JVM (útil debugando com redis-cli).
//
// Esqueleto:
//
//   @Configuration
//   @EnableCaching
//   public class RedisConfig {
//
//       @Bean
//       public RedisCacheManager cacheManager(RedisConnectionFactory cf) {
//           RedisCacheConfiguration defaultConfig = RedisCacheConfiguration.defaultCacheConfig()
//               .entryTtl(Duration.ofMinutes(10))
//               .serializeValuesWith(SerializationPair.fromSerializer(
//                   new GenericJackson2JsonRedisSerializer()));
//
//           Map<String, RedisCacheConfiguration> perCache = Map.of(
//               "viacep", defaultConfig.entryTtl(Duration.ofHours(24)),
//               "users",  defaultConfig.entryTtl(Duration.ofMinutes(5))
//           );
//
//           return RedisCacheManager.builder(cf)
//               .cacheDefaults(defaultConfig)
//               .withInitialCacheConfigurations(perCache)
//               .build();
//       }
//   }
@Configuration
public class RedisConfig {

    // TODO Fase 5: implementar
}
