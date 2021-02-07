package ru.boost.charity.kdc_moderator_app.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Data
@Configuration
@ConfigurationProperties(prefix = "kdc.rest-api")
public class RestConfig {

    private String baseUrl;
    private Tasks tasks;

    @Data
    public static class Tasks {
        private String moderationUrl;
        private String reviewUrl;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .rootUri(baseUrl)
                .build();
    }
}
