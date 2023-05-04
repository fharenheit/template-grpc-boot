package io.datadynamics.template.airflow.model.dag;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@ToString
public class ScheduleInterval {

    @JsonProperty("__type")
    public String get__type() {
        return this.__type;
    }

    public void set__type(String __type) {
        this.__type = __type;
    }

    String __type;

    @JsonProperty("value")
    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    String value;

    @JsonProperty("days")
    public int getDays() {
        return this.days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    int days;

    @JsonProperty("microseconds")
    public int getMicroseconds() {
        return this.microseconds;
    }

    public void setMicroseconds(int microseconds) {
        this.microseconds = microseconds;
    }

    int microseconds;

    @JsonProperty("seconds")
    public int getSeconds() {
        return this.seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    int seconds;
}