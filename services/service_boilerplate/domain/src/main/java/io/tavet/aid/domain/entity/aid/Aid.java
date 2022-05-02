package io.tavet.aid.domain.entity.aid;

import java.util.UUID;

import io.tavet.aid.domain.entity.location.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Aid implements AidOperations {
    private UUID id;
    private Location location;
    private String title;
    private String description;
}
