package io.tavet.aid.domain.service;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

import io.tavet.aid.domain.Aid;

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
