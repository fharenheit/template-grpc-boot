package io.datadynamics.template.airflow.model.dagrun;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Root {

    @JsonProperty("dag_runs")
    ArrayList<DagRun> dagRuns;

    @JsonProperty("total_entries")
    int totalEntries;

}
