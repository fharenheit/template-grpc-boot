package io.datadynamics.template.airflow.model.dag;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

import java.util.ArrayList;

@ToString
public class Root {

    @JsonProperty("dags")
    public ArrayList<Dag> getDags() {
        return this.dags;
    }

    public void setDags(ArrayList<Dag> dags) {
        this.dags = dags;
    }

    ArrayList<Dag> dags;

    @JsonProperty("total_entries")
    public int getTotalEntries() {
        return this.totalEntries;
    }

    public void setTotalEntries(int total_entries) {
        this.totalEntries = total_entries;
    }

    int totalEntries;
}