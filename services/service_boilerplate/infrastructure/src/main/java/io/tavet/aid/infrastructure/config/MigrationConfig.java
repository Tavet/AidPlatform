package io.tavet.aid.infrastructure.config;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.flywaydb.core.Flyway;

import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class MigrationConfig {

    @Inject
    Flyway flyway;
    
    public void checkMigration() {
        log.info("Flyway Migration Service: " + flyway.info().toString());
    }
}
