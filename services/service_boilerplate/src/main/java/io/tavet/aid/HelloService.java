package io.tavet.aid;

import javax.inject.Singleton;

import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;
import io.tavet.aid.proto.Greeter;
import io.tavet.aid.proto.HelloReply;
import io.tavet.aid.proto.HelloRequest;

@GrpcService
public class HelloService implements Greeter {

    @Override
    public Uni<HelloReply> sayHello(HelloRequest request) {
        String name = request.getName();
        String message = "Hello, " + name;
        return Uni.createFrom().item(message)
                .map(r -> HelloReply.newBuilder().setMessage(r).build());
    }
}
