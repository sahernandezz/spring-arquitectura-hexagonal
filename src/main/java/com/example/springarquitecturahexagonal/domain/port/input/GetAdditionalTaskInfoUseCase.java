package com.example.springarquitecturahexagonal.domain.port.input;

import com.example.springarquitecturahexagonal.domain.model.AdditionalTaskInfo;

public interface GetAdditionalTaskInfoUseCase {

    AdditionalTaskInfo getAdditionalTaskInfo(Long id);
}
