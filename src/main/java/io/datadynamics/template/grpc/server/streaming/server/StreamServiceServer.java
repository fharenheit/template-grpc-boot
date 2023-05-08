package io.datadynamics.template.grpc.server.streaming.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class StreamServiceServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(8080)
                .addService(new StreamServiceImpl())
                .build();

        System.out.println("Starting server...");
        server.start();

        System.out.println("Server started!");
        server.awaitTermination();
    }

}