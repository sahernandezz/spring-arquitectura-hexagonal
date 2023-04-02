package com.example.springarquitecturahexagonal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AdditionalTaskInfo {
    private final Long userId;

    private final String userName;

    private final String userEmail;
}
