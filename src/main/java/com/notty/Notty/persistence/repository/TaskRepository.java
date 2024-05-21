package com.notty.Notty.persistence.repository;

import com.notty.Notty.persistence.entity.TaskEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends ListCrudRepository<TaskEntity,Integer> {
    public List<TaskEntity> getByUserOwnerIdUser(Integer idOwner);
    public List<TaskEntity> getByUserOwnerIdUserAndActiveTaskIsTrue(Integer idOwner);
    public List<TaskEntity> findByUserOwnerIdUserAndTimeLimitBeforeAndTaskStatus(Integer userOwner_idUser, LocalDateTime timeLimit, TaskEntity.TaskStatus taskStatus);
}
