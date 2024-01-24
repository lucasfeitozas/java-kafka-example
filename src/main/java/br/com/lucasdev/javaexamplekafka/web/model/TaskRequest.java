package br.com.lucasdev.javaexamplekafka.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {

    private String name;

    public String getName() {
        return name;
    }
}