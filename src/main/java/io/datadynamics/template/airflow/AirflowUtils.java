package io.datadynamics.template.airflow;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.datadynamics.template.airflow.model.dag.Dags;
import io.datadynamics.template.airflow.model.dagrun.DagRunRequest;
import io.datadynamics.template.airflow.model.dagrun.Root;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Airflow 호출을 위한 유틸리티.
 * <p>
 * Airflow의 인증 방식이 Basic Auth가 되어 있는지 확인이 필요하다(airflow config get-value api auth_backends).
 *
 * @ses <a href="https://airflow.apache.org/docs/apache-airflow/stable/administration-and-deployment/security/api.html">API Authentication</a>
 */
public class AirflowUtils {

    public static RestTemplate template = new RestTemplate();

    public static String _AIRFLOW_TIMESTAMP_FORMAT_1 = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX";
    public static String _AIRFLOW_TIMESTAMP_FORMAT_2 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public static SimpleDateFormat timestampFormatter_1 = new SimpleDateFormat(_AIRFLOW_TIMESTAMP_FORMAT_1);
    public static SimpleDateFormat timestampFormatter_2 = new SimpleDateFormat(_AIRFLOW_TIMESTAMP_FORMAT_2);

    public static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        String username = "admin";
        String password = "admin";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth(username, password);

        HttpEntity requestEntity = new HttpEntity(headers);

//        System.out.println(template.exchange("http://192.168.226.129:8080/api/v1/dags?limit=100&only_active=true", HttpMethod.GET, requestEntity, Dags.class).getBody());

        System.out.println(dagRun("tutorial", "fharenheit"));;

//        System.out.println(template.exchange("http://192.168.226.129:8080/api/v1/dags/tutorial/dagRuns?limit=100", HttpMethod.GET, requestEntity, Root.class).getBody());
    }

    public static Map dagRun(String dagId, String ssoId) throws JsonProcessingException {
        String username = "admin";
        String password = "admin";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth(username, password);

        Date now = runningDate();
        HashMap conf = new HashMap();
        conf.put("ssoId", ssoId);
        DagRunRequest req = DagRunRequest.builder()
                .conf(conf)
                .dagRunId(String.format("api__%s__%s", now.getTime(), ssoId))
                .logicalDate(now)
                .note("NOTE NOTE NOTE")
                .build();

        HttpEntity requestEntity = new HttpEntity(req, headers);

        System.out.println(req);
        System.out.println(mapper.writeValueAsString(req));
        System.out.println(requestEntity);

        ResponseEntity<Map> forEntity = template.exchange(
                String.format("http://192.168.226.129:8080/api/v1/dags/%s/dagRuns", dagId),
                HttpMethod.POST,
                requestEntity,
                Map.class);
        return forEntity.getBody();
    }

    public static Date runningDate() {
        Date now1 = new Date();
        Date now2 = DateUtils.addHours(now1, -9);
        Date finalDate = DateUtils.addMinutes(now2, 1);
        System.out.println(timestampFormatter_2.format(finalDate));
        return finalDate;
    }
}