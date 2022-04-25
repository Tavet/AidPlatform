package io.tavet.aid.domain.service;

import java.util.UUID;

import io.tavet.aid.domain.Aid;
import io.tavet.aid.domain.repository.AidRepository;

public class DomainAidService implements AidService {

    private final AidRepository aidRepository;

    public DomainAidService(final AidRepository aidRepository) {
        this.aidRepository = aidRepository;
    }

    @Override
    public UUID createAidRequest(Aid aid) {
        aidRepository.save(aid);

        return UUID.randomUUID();
    }

}
