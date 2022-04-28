package io.tavet.aid.app.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.tavet.aid.domain.entity.aid.Aid;
import lombok.Getter;

@Getter
public class CreateAidRequest {
    @NotNull
    private Aid aid;

    @JsonCreator
    public CreateAidRequest(@JsonProperty("aid") @NotNull final Aid aid) {
        this.aid = aid;
    }
}
