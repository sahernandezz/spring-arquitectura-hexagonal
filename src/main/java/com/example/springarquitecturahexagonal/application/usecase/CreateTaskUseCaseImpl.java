package com.example.springarquitecturahexagonal.application.usecase;

import com.example.springarquitecturahexagonal.domain.model.Task;
import com.example.springarquitecturahexagonal.domain.port.input.CreateTaskUseCase;
import com.example.springarquitecturahexagonal.domain.port.output.TaskRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CreateTaskUseCaseImpl implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Task createTask(Task task) {
        return this.taskRepositoryPort.save(task);
    }
}
