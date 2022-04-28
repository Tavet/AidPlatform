package io.tavet.aid.domain.entity.common;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Exception {
    private final Boolean success = false;
    private LocalDateTime dateTime;
    private String message;
}
