package io.tavet.aid.infrastructure.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Table(name = "aid")
@Getter
public class AidEntity {
    @Id
    @GeneratedValue
    private UUID id;
}
