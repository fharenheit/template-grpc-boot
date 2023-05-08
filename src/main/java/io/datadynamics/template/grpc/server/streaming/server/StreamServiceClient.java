package io.datadynamics.template.grpc.server.streaming.server;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;

@Slf4j
public class StreamServiceClient {

    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        StreamServiceGrpc.StreamServiceBlockingStub stub = StreamServiceGrpc.newBlockingStub(channel);

        Request request = Request.newBuilder().setName("Hello World").build();

        Iterator<Response> datas;
        try {
            datas = stub.getData(request);
            for (int i = 1; datas.hasNext(); i++) {
                Response next = datas.next();
                log.info("Value : {}", next.getToken());
            }
        } catch (StatusRuntimeException e) {
            log.info("RPC failed: {}", e.getStatus());
        }

        channel.shutdown();
    }

}