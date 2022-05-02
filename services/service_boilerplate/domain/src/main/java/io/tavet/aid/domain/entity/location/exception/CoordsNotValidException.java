package io.tavet.aid.domain.entity.location.exception;

import static io.tavet.aid.domain.entity.location.exception.LocationExceptionMessages.COORDS_NOT_VALID;

public class CoordsNotValidException extends LocationException {
    private static final long serialVersionUID = 1L;

    public CoordsNotValidException() {
        super(COORDS_NOT_VALID);
    }
}
