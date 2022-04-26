package io.tavet.aid.infrastructure.repository;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.tavet.aid.domain.Aid;
import io.tavet.aid.domain.repository.AidRepository;
import io.tavet.aid.infrastructure.entity.AidEntity;

@ApplicationScoped
public class PostgresAidRepository implements AidRepository {

    @Inject
    private AidPanacheRepository repository;

    @Override
    public void save(Aid aid) {
        // TODO Auto-generated method stub

    }

    @Override
    public Aid findById(UUID id) {
        AidEntity entity = repository.findById(id);

        return Aid.builder()
                .id(entity.getId()).build();
    }

}
