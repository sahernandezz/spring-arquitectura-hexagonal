package com.example.springarquitecturahexagonal.application.service;

import com.example.springarquitecturahexagonal.domain.model.AdditionalTaskInfo;
import com.example.springarquitecturahexagonal.domain.model.Task;
import com.example.springarquitecturahexagonal.domain.port.input.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TaskService implements CreateTaskUseCase, RetrieveTaskUseCase, DeleteTaskUseCase, UpdateTaskUseCase, GetAdditionalTaskInfoUseCase {

    private final CreateTaskUseCase createTaskUseCase;

    private final RetrieveTaskUseCase retrieveTaskUseCase;

    private final DeleteTaskUseCase deleteTaskUseCase;

    private final UpdateTaskUseCase updateTaskUseCase;

    private final GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;

    @Override
    public Task createTask(Task task) {
        return this.createTaskUseCase.createTask(task);
    }

    @Override
    public boolean deleteTask(Long id) {
        return this.deleteTaskUseCase.deleteTask(id);
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return this.retrieveTaskUseCase.getTask(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return this.retrieveTaskUseCase.getAllTasks();
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updatedTask) {
        return this.updateTaskUseCase.updateTask(id, updatedTask);
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return this.getAdditionalTaskInfoUseCase.getAdditionalTaskInfo(id);
    }
}
