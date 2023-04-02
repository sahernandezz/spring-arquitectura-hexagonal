package com.example.springarquitecturahexagonal.application.usecase;

import com.example.springarquitecturahexagonal.domain.model.Task;
import com.example.springarquitecturahexagonal.domain.port.input.UpdateTaskUseCase;
import com.example.springarquitecturahexagonal.domain.port.output.TaskRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UpdateTaskCaseUseImpl implements UpdateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Optional<Task> updateTask(Long id, Task updatedTask) {
        return this.taskRepositoryPort.update(updatedTask);
    }
}
