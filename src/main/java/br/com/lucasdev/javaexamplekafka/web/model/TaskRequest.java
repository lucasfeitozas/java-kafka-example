package br.com.lucasdev.javaexamplekafka.web.model;

public class TaskRequest {
    public TaskRequest(String name) {
        this.name = name;
    }

    public TaskRequest() {
    }

    private String name;

    public String getName() {
        return name;
    }
}