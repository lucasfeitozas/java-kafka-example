package br.com.lucasdev.javaexamplekafka.web.controller;

import java.util.UUID;

import br.com.lucasdev.javaexamplekafka.jms.service.KafkaConsumerService;
import br.com.lucasdev.javaexamplekafka.web.model.TaskRequest;
import br.com.lucasdev.javaexamplekafka.web.model.TaskResponse;
import br.com.lucasdev.javaexamplekafka.web.model.TaskStatus;
import br.com.lucasdev.javaexamplekafka.web.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    KafkaConsumerService kafkaConsumerService;

    @PostMapping
    public ResponseEntity<TaskResponse> processAsync(@RequestBody TaskRequest taskRequest,
                                                     UriComponentsBuilder b) {

        String taskId = UUID.randomUUID().toString();
        UriComponents progressURL = b.path("/tasks/{id}/progress").buildAndExpand(taskId);
        taskService.process(taskId, taskRequest, b);
        return ResponseEntity.accepted().location(progressURL.toUri()).build();
    }

    @GetMapping("{taskId}/progress")
    public ResponseEntity<?> processAsync(@PathVariable String taskId) {

        TaskStatus taskStatus = kafkaConsumerService.getLatestTaskStatus(taskId);
        if (taskStatus == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(taskStatus);
    }
}
