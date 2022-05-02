package io.tavet.aid.app.rest.exception;

import java.time.LocalDateTime;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import io.tavet.aid.domain.entity.common.Exception;
import io.tavet.aid.domain.entity.location.exception.LocationException;

import static io.tavet.aid.domain.entity.location.exception.LocationExceptionMessages.*;


@Provider
public class LocationExceptionHandler implements ExceptionMapper<LocationException> {

    @Override
    public Response toResponse(LocationException exception) {
        final LocalDateTime time = LocalDateTime.now();

        if (exception.getMessage().equalsIgnoreCase(COORDS_NOT_VALID)) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(Exception.builder().message(exception.getMessage()).dateTime(time).build())
                    .build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(Exception.builder().message(LOCATION_DEFAULT).dateTime(time).build())
                    .build();
        }
    }
}
