package io.tavet.aid.infrastructure.repository;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.tavet.aid.infrastructure.entity.AidEntity;

@ApplicationScoped
public class AidPanacheRepository implements PanacheRepositoryBase<AidEntity, UUID> {
}
