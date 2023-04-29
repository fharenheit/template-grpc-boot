package io.datadynamics.template.grpc.config;

import io.datadynamics.template.grpc.errorhandling.CommodityServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@Slf4j
public class GrpcConfiguration {

    @Bean
    public CommodityServer commodityServer() throws IOException, InterruptedException {
        CommodityServer commodityServer = new CommodityServer(8980);
        commodityServer.start();
        if (commodityServer.getServer() != null) {
            commodityServer.getServer().awaitTermination();
        }
        return commodityServer;
    }

}