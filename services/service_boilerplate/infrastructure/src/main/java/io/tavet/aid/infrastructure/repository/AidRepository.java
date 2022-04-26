package io.tavet.aid.infrastructure.repository;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.tavet.aid.infrastructure.entity.AidEntity;

@ApplicationScoped
public class AidRepository implements PanacheRepository<AidEntity> {
}
