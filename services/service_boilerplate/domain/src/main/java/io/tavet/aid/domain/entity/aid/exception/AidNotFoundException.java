package io.tavet.aid.domain.entity.aid.exception;

import static io.tavet.aid.domain.entity.aid.exception.AidExceptionMessages.AID_NOT_FOUND;

public class AidNotFoundException extends AidException {
    private static final long serialVersionUID = 1L;

    public AidNotFoundException() {
        super(AID_NOT_FOUND);
    }
}
