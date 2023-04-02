package com.example.springarquitecturahexagonal.application.usecase;

import com.example.springarquitecturahexagonal.domain.model.AdditionalTaskInfo;
import com.example.springarquitecturahexagonal.domain.port.input.GetAdditionalTaskInfoUseCase;
import com.example.springarquitecturahexagonal.domain.port.output.ExternalServicePort;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {

    private final ExternalServicePort taskRepositoryPort;

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return this.taskRepositoryPort.getAdditionalTaskInfo(id);
    }
}
