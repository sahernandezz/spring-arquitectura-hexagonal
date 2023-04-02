package com.example.springarquitecturahexagonal.application.usecase;

import com.example.springarquitecturahexagonal.domain.port.input.DeleteTaskUseCase;
import com.example.springarquitecturahexagonal.domain.port.output.TaskRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public boolean deleteTask(Long id) {
        return this.taskRepositoryPort.deleteById(id);
    }
}
