package com.example.springarquitecturahexagonal.domain.port.input;

import com.example.springarquitecturahexagonal.domain.model.Task;

import java.util.List;
import java.util.Optional;

public interface RetrieveTaskUseCase {

    Optional<Task> getTask(Long id);

    List<Task> getAllTasks();
}
