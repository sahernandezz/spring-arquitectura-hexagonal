package com.example.springarquitecturahexagonal.infrastructure.controller;

import com.example.springarquitecturahexagonal.application.service.TaskService;
import com.example.springarquitecturahexagonal.domain.model.Task;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.created(null).body(this.taskService.createTask(task));
    }

    @GetMapping("/{id}")
    ResponseEntity<Task> getTaskById(@PathVariable("id") Long id) {
        return this.taskService.getTask(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(this.taskService.getAllTasks());
    }

    @PutMapping("/{id}")
    ResponseEntity<Task> updateTask(@PathVariable("id") Long id, @RequestBody Task task) {
        return this.taskService.updateTask(id, task)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteTaskById(@PathVariable("id") Long id) {
        return this.taskService.deleteTask(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/additional-info")
    ResponseEntity<?> getAdditionalTaskInfo(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.taskService.getAdditionalTaskInfo(id));
    }
}
