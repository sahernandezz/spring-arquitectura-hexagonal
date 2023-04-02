package com.example.springarquitecturahexagonal.domain.port.input;

import com.example.springarquitecturahexagonal.domain.model.Task;

public interface CreateTaskUseCase {

    Task createTask(Task task);
}
