package com.example.springarquitecturahexagonal.domain.port.output;

import com.example.springarquitecturahexagonal.domain.model.AdditionalTaskInfo;

public interface ExternalServicePort {

    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);
}
