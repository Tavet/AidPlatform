package io.tavet.aid.app.response;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateAidResponse {
    private final UUID id;
}
