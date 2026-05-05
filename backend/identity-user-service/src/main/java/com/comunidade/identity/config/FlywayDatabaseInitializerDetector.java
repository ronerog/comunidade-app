package com.comunidade.identity.config;

import org.flywaydb.core.Flyway;
import org.springframework.boot.sql.init.dependency.AbstractBeansOfTypeDatabaseInitializerDetector;

import java.util.Set;

// Registra o bean Flyway como um "database initializer" no mecanismo do Spring Boot 4.
// O DatabaseInitializationDependencyConfigurer lê esse detector via spring.factories e garante
// que o EntityManagerFactory só inicialize depois que o Flyway migrar o schema.
public class FlywayDatabaseInitializerDetector extends AbstractBeansOfTypeDatabaseInitializerDetector {

    @Override
    protected Set<Class<?>> getDatabaseInitializerBeanTypes() {
        return Set.of(Flyway.class);
    }
}
