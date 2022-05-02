package io.tavet.aid.app.rest;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.tavet.aid.app.request.CreateAidRequest;
import io.tavet.aid.app.response.CreateAidResponse;
import io.tavet.aid.domain.entity.aid.Aid;
import io.tavet.aid.domain.service.AidService;

@Path("/aid")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AidResource {

    private final AidService aidService;

    public AidResource(AidService aidService) {
        this.aidService = aidService;
    }

    @GET
    @Path("/{uuid}")
    public Aid getAidById(@PathParam("uuid") UUID uuid) {
        return aidService.getAidRequest(uuid);
    }

    @POST
    public CreateAidResponse createAidRequest(CreateAidRequest request) {
        System.out.println("REQUEST: " + request.toString());
        final UUID id = aidService.createAidRequest(request.getAid());
        return new CreateAidResponse(id);
    }
}
