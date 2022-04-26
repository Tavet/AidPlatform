package io.tavet.aid.domain.service;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.quarkus.arc.runtime.BeanContainer.Instance;
import io.tavet.aid.domain.Aid;
import io.tavet.aid.domain.repository.AidRepository;

@ApplicationScoped
public class DomainAidService implements AidService {

    // @Inject
    // private Instance<AidRepository> aidRepository;

    @Override
    public UUID createAidRequest(Aid aid) {
        // aidRepository.save(aid);

        return UUID.randomUUID();
    }

    @Override
    public Aid getAidRequest(UUID id) {
        // return aidRepository.findById(id);
        return null;
    }

}
