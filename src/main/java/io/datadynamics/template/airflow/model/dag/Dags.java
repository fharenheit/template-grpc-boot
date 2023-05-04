package io.datadynamics.template.airflow.model.dag;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Dags {

    List<Dag> dags;

    @JsonProperty("total_entries")
    int totalEntries;

}
