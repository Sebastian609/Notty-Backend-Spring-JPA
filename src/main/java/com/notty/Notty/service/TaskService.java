package com.notty.Notty.service;

import com.notty.Notty.persistence.entity.TaskEntity;
import com.notty.Notty.persistence.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService
{
    private final TaskRepository taskRepository;
    @Autowired
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }


    public  List<TaskEntity> getByOwnerId(Integer ownerId){
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

    public TaskEntity changeTaskStatus(Integer id)
    {
        TaskEntity task = get(id);
        TaskEntity.TaskStatus newStatus;
        if (task.getTimeLimit().isBefore(LocalDateTime.now())) {
            newStatus = TaskEntity.TaskStatus.COMPLETED_WHIT_DELAY;
        } else {
            newStatus = TaskEntity.TaskStatus.COMPLETED;
        }
        task.setTaskStatus(newStatus);
        return taskRepository.save(task);
    }


    public boolean delete(Integer id)
    {
        TaskEntity task = get(id);
            task.setActiveTask(false);
            taskRepository.save(task);
            return true;

    }

    public List<TaskEntity> getTodayTasks(Integer  userId){
        LocalDateTime today = LocalDate.now().atTime(0,0);
        return this.taskRepository.findByUserOwnerIdUserAndTimeLimitBeforeAndTaskStatus(userId,today,TaskEntity.TaskStatus.IN_PROGRESS);
    }



}
