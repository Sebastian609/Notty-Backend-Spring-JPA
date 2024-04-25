package com.notty.Notty.persistence.repository;

import com.notty.Notty.persistence.entity.TaskEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface TaskRepository extends ListCrudRepository<TaskEntity,Integer> {
    public List<TaskEntity> getByUserOwnerIdUser(Integer idOwner);
}
