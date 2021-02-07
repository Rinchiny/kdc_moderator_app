package ru.boost.charity.kdc_moderator_app.gateway;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class RestApiGateway {

    private final RestTemplate restTemplate;


    public <T> T performSend(String uri, HttpMethod httpMethod, Class<T> clazz) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<T> response = restTemplate.exchange(uri, httpMethod, entity, clazz);
        return response.getBody();
    }
}
