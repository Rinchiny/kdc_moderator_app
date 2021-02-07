package ru.boost.charity.kdc_moderator_app.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.boost.charity.kdc_moderator_app.config.RestConfig;
import ru.boost.charity.kdc_moderator_app.gateway.RestApiGateway;
import ru.boost.charity.kdc_moderator_app.model.TaskModel;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskService {

    private final RestConfig restConfig;
    private final RestApiGateway apiGateway;


    public List<TaskModel> getTasksOnModeration() {
        String uri = restConfig.getTasks().getModerationUrl();
        var result = apiGateway.performSend(uri, HttpMethod.GET, TaskModel[].class);
        return Arrays.asList(result);
    }

    public List<TaskModel> getTasksOnReview() {
        String uri = restConfig.getTasks().getReviewUrl();
        var result = apiGateway.performSend(uri, HttpMethod.GET, TaskModel[].class);
        return Arrays.asList(result);
    }
}
