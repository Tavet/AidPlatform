package io.tavet.aid.domain;

import java.util.Objects;
import java.util.UUID;

import lombok.Getter;

@Getter
public class Aid {
    private UUID id;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Aid))
            return false;
        Aid other = (Aid) obj;
        return Objects.equals(id, other.id);
    }
}
