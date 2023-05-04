package io.datadynamics.template.airflow.model.dag;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;

@ToString
public class Dag {
    @JsonProperty("dag_id")
    public String getDag_id() {
        return this.dag_id;
    }

    public void setDag_id(String dag_id) {
        this.dag_id = dag_id;
    }

    String dag_id;

    @JsonProperty("default_view")
    public String getDefault_view() {
        return this.default_view;
    }

    public void setDefault_view(String default_view) {
        this.default_view = default_view;
    }

    String default_view;

    @JsonProperty("description")
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    String description;

    @JsonProperty("file_token")
    public String getFile_token() {
        return this.file_token;
    }

    public void setFile_token(String file_token) {
        this.file_token = file_token;
    }

    String file_token;

    @JsonProperty("fileloc")
    public String getFileloc() {
        return this.fileloc;
    }

    public void setFileloc(String fileloc) {
        this.fileloc = fileloc;
    }

    String fileloc;

    @JsonProperty("has_import_errors")
    public boolean getHas_import_errors() {
        return this.has_import_errors;
    }

    public void setHas_import_errors(boolean has_import_errors) {
        this.has_import_errors = has_import_errors;
    }

    boolean has_import_errors;

    @JsonProperty("has_task_concurrency_limits")
    public boolean getHas_task_concurrency_limits() {
        return this.has_task_concurrency_limits;
    }

    public void setHas_task_concurrency_limits(boolean has_task_concurrency_limits) {
        this.has_task_concurrency_limits = has_task_concurrency_limits;
    }

    boolean has_task_concurrency_limits;

    @JsonProperty("is_active")
    public boolean getIs_active() {
        return this.is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    boolean is_active;

    @JsonProperty("is_paused")
    public boolean getIs_paused() {
        return this.is_paused;
    }

    public void setIs_paused(boolean is_paused) {
        this.is_paused = is_paused;
    }

    boolean is_paused;

    @JsonProperty("is_subdag")
    public boolean getIs_subdag() {
        return this.is_subdag;
    }

    public void setIs_subdag(boolean is_subdag) {
        this.is_subdag = is_subdag;
    }

    boolean is_subdag;

    @JsonProperty("last_expired")
    public Object getLast_expired() {
        return this.last_expired;
    }

    public void setLast_expired(Object last_expired) {
        this.last_expired = last_expired;
    }

    Object last_expired;

    @JsonProperty("last_parsed_time")
    public Date getLast_parsed_time() {
        return this.last_parsed_time;
    }

    public void setLast_parsed_time(Date last_parsed_time) {
        this.last_parsed_time = last_parsed_time;
    }

    Date last_parsed_time;

    @JsonProperty("last_pickled")
    public Object getLast_pickled() {
        return this.last_pickled;
    }

    public void setLast_pickled(Object last_pickled) {
        this.last_pickled = last_pickled;
    }

    Object last_pickled;

    @JsonProperty("max_active_runs")
    public int getMax_active_runs() {
        return this.max_active_runs;
    }

    public void setMax_active_runs(int max_active_runs) {
        this.max_active_runs = max_active_runs;
    }

    int max_active_runs;

    @JsonProperty("max_active_tasks")
    public int getMax_active_tasks() {
        return this.max_active_tasks;
    }

    public void setMax_active_tasks(int max_active_tasks) {
        this.max_active_tasks = max_active_tasks;
    }

    int max_active_tasks;

    @JsonProperty("next_dagrun")
    public Date getNext_dagrun() {
        return this.next_dagrun;
    }

    public void setNext_dagrun(Date next_dagrun) {
        this.next_dagrun = next_dagrun;
    }

    Date next_dagrun;

    @JsonProperty("next_dagrun_create_after")
    public Date getNext_dagrun_create_after() {
        return this.next_dagrun_create_after;
    }

    public void setNext_dagrun_create_after(Date next_dagrun_create_after) {
        this.next_dagrun_create_after = next_dagrun_create_after;
    }

    Date next_dagrun_create_after;

    @JsonProperty("next_dagrun_data_interval_end")
    public Date getNext_dagrun_data_interval_end() {
        return this.next_dagrun_data_interval_end;
    }

    public void setNext_dagrun_data_interval_end(Date next_dagrun_data_interval_end) {
        this.next_dagrun_data_interval_end = next_dagrun_data_interval_end;
    }

    Date next_dagrun_data_interval_end;

    @JsonProperty("next_dagrun_data_interval_start")
    public Date getNext_dagrun_data_interval_start() {
        return this.next_dagrun_data_interval_start;
    }

    public void setNext_dagrun_data_interval_start(Date next_dagrun_data_interval_start) {
        this.next_dagrun_data_interval_start = next_dagrun_data_interval_start;
    }

    Date next_dagrun_data_interval_start;

    @JsonProperty("owners")
    public ArrayList<String> getOwners() {
        return this.owners;
    }

    public void setOwners(ArrayList<String> owners) {
        this.owners = owners;
    }

    ArrayList<String> owners;

    @JsonProperty("pickle_id")
    public Object getPickle_id() {
        return this.pickle_id;
    }

    public void setPickle_id(Object pickle_id) {
        this.pickle_id = pickle_id;
    }

    Object pickle_id;

    @JsonProperty("root_dag_id")
    public Object getRoot_dag_id() {
        return this.root_dag_id;
    }

    public void setRoot_dag_id(Object root_dag_id) {
        this.root_dag_id = root_dag_id;
    }

    Object root_dag_id;

    @JsonProperty("schedule_interval")
    public ScheduleInterval getSchedule_interval() {
        return this.schedule_interval;
    }

    public void setSchedule_interval(ScheduleInterval schedule_interval) {
        this.schedule_interval = schedule_interval;
    }

    ScheduleInterval schedule_interval;

    @JsonProperty("scheduler_lock")
    public Object getScheduler_lock() {
        return this.scheduler_lock;
    }

    public void setScheduler_lock(Object scheduler_lock) {
        this.scheduler_lock = scheduler_lock;
    }

    Object scheduler_lock;

    @JsonProperty("tags")
    public ArrayList<Tag> getTags() {
        return this.tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    ArrayList<Tag> tags;

    @JsonProperty("timetable_description")
    public String getTimetable_description() {
        return this.timetable_description;
    }

    public void setTimetable_description(String timetable_description) {
        this.timetable_description = timetable_description;
    }

    String timetable_description;
}
