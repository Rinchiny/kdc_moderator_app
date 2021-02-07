package ru.boost.charity.kdc_moderator_app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.boost.charity.kdc_moderator_app.model.TaskModel;
import ru.boost.charity.kdc_moderator_app.service.TaskService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest/task")
@RequiredArgsConstructor
public class TaskRestController {

    private final TaskService service;


    @GetMapping(path = "/moderation")
    public ResponseEntity<List<TaskModel>> getTasksOnModeration() {
        return new ResponseEntity<>(service.getTasksOnModeration(), HttpStatus.OK);
    }

    @GetMapping("/review")
    public ResponseEntity<List<TaskModel>> getTasksOnReview() {
        return new ResponseEntity<>(service.getTasksOnReview(), HttpStatus.OK);
    }
}
