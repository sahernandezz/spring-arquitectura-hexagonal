package com.example.springarquitecturahexagonal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class Task {
    private Long id;

    private String title;

    private String description;

    private LocalDateTime creationDate;

    private boolean completed;
}
