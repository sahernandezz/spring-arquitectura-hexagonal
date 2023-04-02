package com.example.springarquitecturahexagonal.infrastructure.entity;

import com.example.springarquitecturahexagonal.domain.model.Task;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    private String description;

    private LocalDateTime creationDate;

    private boolean completed;

    public static TaskEntity fromDomainModel(Task task) {
        return TaskEntity.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .creationDate(task.getCreationDate())
                .completed(task.isCompleted())
                .build();
    }

    public Task toDomainModel() {
        return Task.builder()
                .id(this.id)
                .title(this.title)
                .description(this.description)
                .creationDate(this.creationDate)
                .completed(this.completed)
                .build();
    }

}
