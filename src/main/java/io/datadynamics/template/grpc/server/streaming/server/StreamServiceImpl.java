package io.datadynamics.template.grpc.server.streaming.server;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamServiceImpl extends StreamServiceGrpc.StreamServiceImplBase {

    @Override
    public void getData(Request request, StreamObserver<Response> responseObserver) {
        String requestName = request.getName();
        log.info("Request Name : {}", requestName);

        for (int i = 1; i <= 5; i++) {
            Response response = Response.newBuilder().setToken(requestName + "_" + System.currentTimeMillis()).build();
            responseObserver.onNext(response);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
        responseObserver.onCompleted();
    }
}