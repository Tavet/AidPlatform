package io.tavet.aid.app.rest.exception;

import java.time.LocalDateTime;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static io.tavet.aid.domain.entity.aid.exception.AidExceptionMessages.*;
import io.tavet.aid.domain.entity.aid.exception.AidException;
import io.tavet.aid.domain.entity.common.Exception;

@Provider
public class AidExceptionHandler implements ExceptionMapper<AidException> {

    @Override
    public Response toResponse(AidException exception) {
        final LocalDateTime time = LocalDateTime.now();

        if (exception.getMessage().equalsIgnoreCase(AID_NOT_FOUND)) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(Exception.builder().message(exception.getMessage()).dateTime(time).build())
                    .build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(Exception.builder().message(AID_DEFAULT).dateTime(time).build())
                    .build();
        }
    }

}
