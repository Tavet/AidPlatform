package io.tavet.aid.app.rest;

import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.tavet.aid.app.request.CreateAidRequest;
import io.tavet.aid.app.response.CreateAidResponse;
import io.tavet.aid.domain.Aid;
import io.tavet.aid.domain.service.AidService;

@Path("/aid")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AidResource {

    @Inject
    private AidService aidService;

    @GET
    public Aid hello() {
        return new Aid();
    }

    @POST
    public CreateAidResponse createAidRequest(CreateAidRequest request) {
        final UUID id = aidService.createAidRequest(request.getAid());
        return new CreateAidResponse(id);
    }
}
