package io.tavet.aid.domain.repository;

import java.util.UUID;

import io.tavet.aid.domain.Aid;

public interface AidRepository {
    void save(Aid aid);
    Aid findById(UUID id);
}
