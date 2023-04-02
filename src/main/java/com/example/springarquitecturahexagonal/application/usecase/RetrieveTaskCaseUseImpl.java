package com.example.springarquitecturahexagonal.application.usecase;

import com.example.springarquitecturahexagonal.domain.model.Task;
import com.example.springarquitecturahexagonal.domain.port.input.RetrieveTaskUseCase;
import com.example.springarquitecturahexagonal.domain.port.output.TaskRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RetrieveTaskCaseUseImpl implements RetrieveTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Optional<Task> getTask(Long id) {
        return this.taskRepositoryPort.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return this.taskRepositoryPort.findAll();
    }
}
