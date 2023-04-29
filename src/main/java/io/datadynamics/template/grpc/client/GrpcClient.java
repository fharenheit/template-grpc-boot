package io.datadynamics.template.grpc.client;

import io.datadynamics.template.grpc.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFirstName("Baeldung")
                .setLastName("gRPC")
                .build());

        System.out.println("Response received from server:\n" + helloResponse);

        HelloResponseMap helloResponseMap = stub.helloMap(HelloRequestMap.newBuilder()
                .putArgs("hello", "world")
                .build());
        System.out.println("Response received from server:\n" + helloResponseMap);

        channel.shutdown();
    }

}