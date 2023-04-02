package com.example.springarquitecturahexagonal.infrastructure.repository;

import com.example.springarquitecturahexagonal.infrastructure.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTaskRepository extends JpaRepository<TaskEntity, Long> {

}
