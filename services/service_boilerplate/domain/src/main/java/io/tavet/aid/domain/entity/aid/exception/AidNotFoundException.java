package io.tavet.aid.domain.entity.aid.exception;

public class AidNotFoundException extends AidException {
    private static final long serialVersionUID = 1L;
    private static final String MESSAGE = "Resource not found";

    public AidNotFoundException() {
        super(MESSAGE);
    }
}
