package io.tavet.aid.infrastructure.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AidEntity {
    @Id
    @GeneratedValue
    private UUID id;
}
