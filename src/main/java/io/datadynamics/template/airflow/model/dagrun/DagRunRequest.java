package io.datadynamics.template.airflow.model.dagrun;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.Map;

@Data
@ToString
@Builder
public class DagRunRequest {

    @JsonProperty("conf")
    Map<String, String> conf;

    @JsonProperty("dag_run_id")
    String dagRunId;

    @JsonProperty("logical_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    Date logicalDate;

    @JsonProperty("note")
    String note;
}
