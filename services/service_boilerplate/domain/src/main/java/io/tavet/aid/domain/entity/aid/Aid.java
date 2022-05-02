package io.tavet.aid.domain.entity.aid;

import java.util.UUID;

import io.tavet.aid.domain.entity.location.GeoLocation;
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
    private GeoLocation location;
    private String title;
    private String description;
}
