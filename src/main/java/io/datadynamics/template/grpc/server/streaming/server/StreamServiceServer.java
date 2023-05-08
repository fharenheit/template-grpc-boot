package io.datadynamics.template.grpc.server.streaming.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class StreamServiceServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(8080)
                .addService(new StreamServiceImpl())
                .build();

        log.info("Starting server...");
        server.start();

        log.info("Server started!");
        server.awaitTermination();
    }

}