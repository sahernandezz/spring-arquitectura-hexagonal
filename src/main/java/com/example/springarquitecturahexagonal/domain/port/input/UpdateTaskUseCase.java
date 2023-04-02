package com.example.springarquitecturahexagonal.domain.port.input;

import com.example.springarquitecturahexagonal.domain.model.Task;

import java.util.Optional;

public interface UpdateTaskUseCase {

    Optional<Task> updateTask(Long id, Task updatedTask);
}
