package io.tavet.aid.domain.repository;

import java.util.UUID;

import io.tavet.aid.domain.entity.aid.Aid;

public interface AidRepository {
    UUID save(Aid aid);
    Aid findById(UUID id);
}
