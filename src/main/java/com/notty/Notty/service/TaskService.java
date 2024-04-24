package com.notty.Notty.service;

import com.notty.Notty.persistence.entity.TaskEntity;
import com.notty.Notty.persistence.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

@Service
public class TaskService
{
    private final TaskRepository taskRepository;
    @Autowired
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<TaskEntity> getByOwneId(Integer ownerId){
        return this.taskRepository.getByUserOwnerIdUser(ownerId);
    }

    public TaskEntity get(Integer id){
        return this.taskRepository.findById(id).orElse(null);
    }

    public boolean exists(int idTask) {
        return this.taskRepository.existsById(idTask);
    }

    public List<TaskEntity> getAll() {
        return this.taskRepository.findAll();
    }

    public TaskEntity save(TaskEntity taskEntity){
        return this.taskRepository.save(taskEntity);
    }
}
