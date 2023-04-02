package com.example.springarquitecturahexagonal.infrastructure.config;

import com.example.springarquitecturahexagonal.application.service.TaskService;
import com.example.springarquitecturahexagonal.application.usecase.*;
import com.example.springarquitecturahexagonal.domain.port.input.GetAdditionalTaskInfoUseCase;
import com.example.springarquitecturahexagonal.domain.port.output.ExternalServicePort;
import com.example.springarquitecturahexagonal.domain.port.output.TaskRepositoryPort;
import com.example.springarquitecturahexagonal.infrastructure.adapter.ExternalServiceAdapter;
import com.example.springarquitecturahexagonal.infrastructure.repository.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        return new TaskService(
                new CreateTaskUseCaseImpl(taskRepositoryPort),
                new RetrieveTaskCaseUseImpl(taskRepositoryPort),
                new DeleteTaskUseCaseImpl(taskRepositoryPort),
                new UpdateTaskCaseUseImpl(taskRepositoryPort),
                getAdditionalTaskInfoUseCase
        );
    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter) {
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(ExternalServicePort externalServicePort) {
        return new GetAdditionalTaskInfoUseCaseImpl(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort() {
        return new ExternalServiceAdapter();
    }
}
