package io.datadynamics.template.grpc.server;

import io.datadynamics.template.grpc.*;
import io.grpc.stub.StreamObserver;

import java.util.Map;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        System.out.println("Request received from client:\n" + request);

        String greeting = new StringBuilder().append("Hello, ")
                .append(request.getFirstName())
                .append(" ")
                .append(request.getLastName())
                .toString();

        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void helloMap(HelloRequestMap request, StreamObserver<HelloResponseMap> responseObserver) {
        Map<String, String> argsMap = request.getArgsMap();
        String hello = argsMap.get("hello");

        HelloResponseMap response = HelloResponseMap.newBuilder().putResult("hello", hello).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}