package br.com.lucasdev.javaexamplekafka.web.model;

import java.io.Serializable;

public class TaskResponse implements Serializable {

    public TaskResponse(String taskId, String name) {
        this.taskId = taskId;
        this.name = name;
    }

    public TaskResponse() {
    }

    private String taskId;
    private String name;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}