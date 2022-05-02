package io.tavet.aid.domain.entity.location.exception;

public class LocationException extends RuntimeException {
    LocationException(final String message) {
        super(message);
    }
}
