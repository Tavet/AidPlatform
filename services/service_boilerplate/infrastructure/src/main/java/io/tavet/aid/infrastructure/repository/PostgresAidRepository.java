package io.tavet.aid.infrastructure.repository;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.tavet.aid.domain.entity.aid.Aid;
import io.tavet.aid.domain.entity.aid.exception.AidNotFoundException;
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
        Optional<AidEntity> response = Optional.ofNullable(repository.findById(id));

        AidEntity entity = response
                .filter(Objects::nonNull)
                .orElseThrow(AidNotFoundException::new);

        return Aid.builder()
                .id(entity.getId()).build();
    }

}
