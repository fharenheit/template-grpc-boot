package io.datadynamics.template.grpc.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Jackson 등의 유티릴티성 클래스를 Autowire하고자 하는 경우에 Bean을 정의하도록 함.
 */
@Configuration
@Slf4j
public class UtilityConfiguration {

    @Bean("mapper")
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper;
    }

}