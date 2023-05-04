package io.datadynamics.template.airflow;

import io.datadynamics.template.airflow.model.Dags;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Airflow 호출을 위한 유틸리티.
 *
 * Airflow의 인증 방식이 Basic Auth가 되어 있는지 확인이 필요하다(airflow config get-value api auth_backends).
 *
 * @ses <a href="https://airflow.apache.org/docs/apache-airflow/stable/administration-and-deployment/security/api.html">API Authentication</a>
 */
public class AirflowUtils {

    public static RestTemplate template = new RestTemplate();

    public static void main(String[] args) {

        String username = "admin";
        String password = "admin";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth(username, password);

        HttpEntity requestEntity = new HttpEntity(headers);

        System.out.println(requestEntity);

        ResponseEntity<Dags> forEntity = template.exchange
                ("http://192.168.226.129:8080/api/v1/dags?limit=100&only_active=true",
                        HttpMethod.GET, requestEntity, Dags.class);

        System.out.println(forEntity.getBody());
    }

}
