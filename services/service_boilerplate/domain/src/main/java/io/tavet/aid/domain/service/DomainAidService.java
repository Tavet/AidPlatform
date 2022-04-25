package io.tavet.aid.domain.service;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Singleton;

import io.quarkus.arc.DefaultBean;
import io.tavet.aid.domain.Aid;
import io.tavet.aid.domain.repository.AidRepository;

@ApplicationScoped
public class DomainAidService implements AidService {

    // @Inject
    // private AidRepository aidRepository;

    @Override
    public UUID createAidRequest(Aid aid) {
        // aidRepository.save(aid);

        return UUID.randomUUID();
    }

}
