package com.comunidade.catalog.config;

import org.springframework.context.annotation.Configuration;

// TODO Fase 5: cache da vitrine.
//
// O catálogo é leitura-pesada (RF: muitas consultas, poucas criações).
// Caches sugeridos:
//   - "vitrine"        -> listagem paginada (TTL 5-10 min, invalidar em create/update)
//   - "service-detail" -> detalhe por id  (TTL 30 min, invalidar em update do mesmo id)
//   - "categories"     -> lista de categorias (TTL 24h — muda raramente)
//
// Use o mesmo padrão de configuração que mostramos no identity (RedisCacheManager
// com TTL por nome de cache).
@Configuration
public class RedisConfig {

    // TODO Fase 5: implementar
}
