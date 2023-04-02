package com.example.springarquitecturahexagonal.infrastructure.adapter;

import com.example.springarquitecturahexagonal.domain.model.AdditionalTaskInfo;
import com.example.springarquitecturahexagonal.domain.port.output.ExternalServicePort;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ExternalServiceAdapter implements ExternalServicePort {

    private final RestTemplate restTemplate;

    public ExternalServiceAdapter() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
        String apiUrl = "https://jsonplaceholder.typicode.com/todos/" + taskId;
        ResponseEntity<JsonPlaceholderTodo> response = restTemplate.getForEntity(apiUrl, JsonPlaceholderTodo.class);
        JsonPlaceholderTodo todo = response.getBody();

        if (todo == null)
            return null;

        apiUrl = "https://jsonplaceholder.typicode.com/users/" + todo.getUserId();
        ResponseEntity<JsonPlaceholderUser> responseUser = restTemplate.getForEntity(apiUrl, JsonPlaceholderUser.class);
        JsonPlaceholderUser user = responseUser.getBody();

        if (user == null)
            return null;

        return AdditionalTaskInfo.builder()
                .userId(user.getId())
                .userName(user.getName())
                .userEmail(user.getEmail())
                .build();
    }

    @Data
    private static class JsonPlaceholderTodo {
        private Long id;
        private Long userId;
    }

    @Data
    private static class JsonPlaceholderUser {
        private Long id;
        private String name;
        private String email;
    }

}
