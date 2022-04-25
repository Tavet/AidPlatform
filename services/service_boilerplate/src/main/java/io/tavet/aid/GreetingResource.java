package io.tavet.aid;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.grpc.GrpcClient;
import io.tavet.aid.proto.GreeterGrpc;
import io.tavet.aid.proto.HelloRequest;

@Path("/hello")
public class GreetingResource {

    @Inject
    @GrpcClient("hello")
    GreeterGrpc.GreeterBlockingStub client;

    @GET
    @Path("/{name}")
    public String hello(@PathParam("name") String name) {
        return client.sayHello(HelloRequest.newBuilder().setName(name).build()).getMessage();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }
}