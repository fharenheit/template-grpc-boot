package io.datadynamics.template.airflow;

import io.datadynamics.template.airflow.model.dag.Dags;
import io.datadynamics.template.airflow.model.dagrun.Root;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * Airflow 호출을 위한 유틸리티.
 * <p>
 * Airflow의 인증 방식이 Basic Auth가 되어 있는지 확인이 필요하다(airflow config get-value api auth_backends).
 *
 * @ses <a href="https://airflow.apache.org/docs/apache-airflow/stable/administration-and-deployment/security/api.html">API Authentication</a>
 */
public class AirflowUtils {

    public static RestTemplate template = new RestTemplate();

    public static String _AIRFLOW_TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX";

    public static SimpleDateFormat timestampFormatter = new SimpleDateFormat(_AIRFLOW_TIMESTAMP_FORMAT);

    public static void main(String[] args) {
        String username = "admin";
        String password = "admin";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth(username, password);

        HttpEntity requestEntity = new HttpEntity(headers);

        System.out.println(template.exchange("http://192.168.226.129:8080/api/v1/dags?limit=100&only_active=true", HttpMethod.GET, requestEntity, Dags.class).getBody());
        System.out.println(template.exchange("http://192.168.226.129:8080/api/v1/dags/tutorial/dagRuns?limit=100", HttpMethod.GET, requestEntity, Root.class).getBody());
    }
}