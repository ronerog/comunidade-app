package com.comunidade.identity.config;

import org.springframework.context.annotation.Configuration;

// TODO: Configurar o Redis
// Dicas do que você vai precisar:
// - @EnableCaching (habilita o uso de @Cacheable nos services)
// - RedisTemplate<String, Object> (para operações manuais no Redis)
// - RedisCacheManager (para configurar TTL padrão do cache)
@Configuration
public class RedisConfig {

}
