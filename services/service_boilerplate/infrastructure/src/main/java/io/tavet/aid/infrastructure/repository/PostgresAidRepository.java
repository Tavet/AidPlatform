package io.tavet.aid.infrastructure.repository;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import io.tavet.aid.domain.entity.aid.Aid;
import io.tavet.aid.domain.entity.aid.exception.AidNotFoundException;
import io.tavet.aid.domain.entity.location.Location;
import io.tavet.aid.domain.repository.AidRepository;
import io.tavet.aid.infrastructure.entity.AidEntity;

@ApplicationScoped
public class PostgresAidRepository implements AidRepository {

    private final AidPanacheRepository repository;

    public PostgresAidRepository(AidPanacheRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public UUID save(Aid aid) {
        AidEntity entity = AidEntity.builder()
                .longitude(aid.getLocation().getLongitude())
                .latitude(aid.getLocation().getLatitude())
                .title(aid.getTitle())
                .description(aid.getDescription()).build();

        repository.persist(entity);
        return entity.getId();
    }

    @Override
    public Aid findById(UUID id) {
        Optional<AidEntity> response = Optional.ofNullable(repository.findById(id));

        AidEntity entity = response
                .filter(Objects::nonNull)
                .orElseThrow(AidNotFoundException::new);

        return Aid.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .title(entity.getTitle())
                .location(new Location(entity.getLatitude(), entity.getLongitude())).build();
    }

}
