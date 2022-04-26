package io.tavet.aid.domain.service;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

import io.tavet.aid.domain.Aid;
import io.tavet.aid.domain.repository.AidRepository;

@ApplicationScoped
public class DomainAidService implements AidService {

    final AidRepository aidRepository;

    public DomainAidService(AidRepository aidRepository) {
        this.aidRepository = aidRepository;
    }

    @Override
    public UUID createAidRequest(Aid aid) {
        // aidRepository.save(aid);

        return UUID.randomUUID();
    }

    @Override
    public Aid getAidRequest(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }

}
