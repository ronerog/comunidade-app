package com.comunidade.identity.config;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

// Spring Boot 4 não tem auto-configuração do Flyway embutida — precisamos configurar manualmente.
// O FlywayDatabaseInitializerDetector (em spring.factories) garante que o JPA espere o Flyway
// terminar antes de validar o schema.
@Configuration
public class FlywayConfig {

    @Bean
    public Flyway flyway(DataSource dataSource) {
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db/migration")
                .baselineOnMigrate(true)
                .baselineVersion("0")
                .load();
        flyway.migrate();
        return flyway;
    }
}
