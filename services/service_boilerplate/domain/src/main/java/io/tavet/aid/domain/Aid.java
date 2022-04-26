package io.tavet.aid.domain;

import java.util.UUID;

import lombok.Getter;

@Getter
public class Aid {
    private UUID id;
    private Location location;
    private String title;
    private String description;
}
