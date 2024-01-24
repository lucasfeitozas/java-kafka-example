package br.com.lucasdev.javaexamplekafka.web.model;

import java.io.Serializable;

public class TaskStatus implements Serializable {

    public TaskStatus(String taskId, String taskName, float percentageComplete, Status status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.percentageComplete = percentageComplete;
        this.status = status;
    }

    public TaskStatus() {
    }

    private String taskId;
    private String taskName;
    private float percentageComplete;
    private Status status;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public float getPercentageComplete() {
        return percentageComplete;
    }

    public void setPercentageComplete(float percentageComplete) {
        this.percentageComplete = percentageComplete;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status {
        SUBMITTED, STARTED, RUNNING, FINISHED, TERMINATED
    }
}
