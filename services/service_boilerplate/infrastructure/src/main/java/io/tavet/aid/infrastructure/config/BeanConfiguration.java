package io.tavet.aid.infrastructure.config;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Produces;

import io.tavet.aid.domain.repository.AidRepository;
import io.tavet.aid.domain.service.AidService;
import io.tavet.aid.domain.service.DomainAidService;

@ApplicationScoped
public class BeanConfiguration {
    
    @Produces
    AidService aidService(final AidRepository aidRepository) {
        return new DomainAidService(aidRepository);
    }
}
