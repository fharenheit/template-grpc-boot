package io.datadynamics.template.airflow.model.dagrun;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.Map;

@Data
@ToString
public class DagRun {

    @JsonProperty("conf")
    Map<String, String> conf;

    @JsonProperty("dag_id")
    String dagId;

    @JsonProperty("dag_run_id")
    String dag_run_id;

    @JsonProperty("data_interval_end")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX")
    Date dataIntervalEnd;

    @JsonProperty("data_interval_start")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX")
    Date dataIntervalStart;

    @JsonProperty("end_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX")
    Date endDate;

    @JsonProperty("external_trigger")
    boolean externalTrigger;

    @JsonProperty("last_scheduling_decision")
    Date lastSchedulingDecision;

    @JsonProperty("logical_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX")
    Date logicalDate;

    @JsonProperty("note")
    String note;

    @JsonProperty("run_type")
    String runType;

    @JsonProperty("start_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX")
    Date startDate;

    @JsonProperty("state")
    String state;
}