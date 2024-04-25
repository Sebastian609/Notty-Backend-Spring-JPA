package com.notty.Notty.web.controller;

import com.notty.Notty.persistence.entity.TaskEntity;
import com.notty.Notty.persistence.entity.UserEntity;
import com.notty.Notty.service.TaskService;
import com.notty.Notty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskEntity>> getAll(){
        return ResponseEntity.ok(this.taskService.getAll());
    }


    @PostMapping
    public ResponseEntity<TaskEntity> save(@RequestBody TaskEntity task){
        if(task.getIdTask() == null || this.taskService.exists(task.getIdTask())){
            task.setTaskStatus(TaskEntity.TaskStatus.IN_PROGRESS);
            task.setCreaterAt(LocalDateTime.now());
            task.setUpdatedAt(LocalDateTime.now());
            return  ResponseEntity.ok(this.taskService.save(task));
        }
        return ResponseEntity.badRequest().build();
    }
    @GetMapping("changeStatus/{taskId}")
    public ResponseEntity<TaskEntity> changeStatus(@PathVariable Integer taskId)
    {
        if(this.taskService.exists(taskId)){
            return  ResponseEntity.ok(this.taskService.changeTaskStatus(taskId));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("owner/{ownerId}")
    public ResponseEntity<List<TaskEntity>> getByOwnerId(@PathVariable Integer ownerId){
        return ResponseEntity.ok(this.taskService.getByOwnerId(ownerId));
    }

    @PutMapping
    public ResponseEntity<TaskEntity> update(@RequestBody TaskEntity task){
        if(task.getIdTask() != null && this.taskService.exists(task.getIdTask())){
            return ResponseEntity.ok(this.taskService.save(task));
        }
        return ResponseEntity.badRequest().build();
    }


}
