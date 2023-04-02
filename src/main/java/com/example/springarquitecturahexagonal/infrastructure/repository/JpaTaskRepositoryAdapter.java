package com.example.springarquitecturahexagonal.infrastructure.repository;

import com.example.springarquitecturahexagonal.domain.model.Task;
import com.example.springarquitecturahexagonal.domain.port.output.TaskRepositoryPort;
import com.example.springarquitecturahexagonal.infrastructure.entity.TaskEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JpaTaskRepositoryAdapter implements TaskRepositoryPort {

    private final JpaTaskRepository jpaTaskRepository;

    @Override
    public Task save(Task task) {
        return this.jpaTaskRepository.save(TaskEntity.fromDomainModel(task)).toDomainModel();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return this.jpaTaskRepository.findById(id).map(TaskEntity::toDomainModel);
    }

    @Override
    public List<Task> findAll() {
        return this.jpaTaskRepository.findAll().stream().map(TaskEntity::toDomainModel).toList();
    }

    @Override
    public Optional<Task> update(Task task) {
        return this.jpaTaskRepository.existsById(task.getId())
                ? Optional.of(this.jpaTaskRepository.save(TaskEntity.fromDomainModel(task)).toDomainModel())
                : Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        boolean exists = this.jpaTaskRepository.existsById(id);
        if (exists) {
            this.jpaTaskRepository.deleteById(id);
        }
        return exists;
    }
}
