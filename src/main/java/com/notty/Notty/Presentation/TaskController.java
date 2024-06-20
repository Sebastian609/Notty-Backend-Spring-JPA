package com.notty.Notty.Presentation;

import com.notty.Notty.Domain.DTO.TaskDTO;
import com.notty.Notty.Domain.TaskEntity;
import com.notty.Notty.Aplication.TaskService;
import com.notty.Notty.Infraestructure.Mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAll() {
        List<TaskDTO> tasks = this.taskService.getAll().stream()
                .map(taskMapper::toTaskDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<TaskDTO> save(@RequestBody TaskDTO taskDTO) {
        if(taskDTO.getIdTask() == null || !this.taskService.exists(taskDTO.getIdTask())) {
            TaskEntity task = taskMapper.toTaskEntity(taskDTO);
            task.setTaskStatus(TaskEntity.TaskStatus.IN_PROGRESS);
            task.setCreaterAt(LocalDateTime.now());
            task.setUpdatedAt(LocalDateTime.now());
            TaskEntity savedTask = this.taskService.save(task);
            return ResponseEntity.ok(taskMapper.toTaskDTO(savedTask));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("changeStatus/{taskId}")
    public ResponseEntity<TaskDTO> changeStatus(@PathVariable Integer taskId) {
        if(this.taskService.exists(taskId)) {
            TaskEntity updatedTask = this.taskService.changeTaskStatus(taskId);
            return ResponseEntity.ok(taskMapper.toTaskDTO(updatedTask));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("owner/{ownerId}")
    public ResponseEntity<List<TaskDTO>> getByOwnerId(@PathVariable Integer ownerId) {
        List<TaskDTO> tasks = this.taskService.getByOwnerId(ownerId).stream()
                .map(taskMapper::toTaskDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("owner/activeTasks/{ownerId}")
    public ResponseEntity<List<TaskDTO>> getActiveTasksByOwnerID(@PathVariable Integer ownerId) {
        List<TaskDTO> tasks = this.taskService.getAllActiveTasksByOwner(ownerId).stream()
                .map(taskMapper::toTaskDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(tasks);
    }

    @PutMapping
    public ResponseEntity<TaskDTO> update(@RequestBody TaskDTO taskDTO) {
        if(taskDTO.getIdTask() != null && this.taskService.exists(taskDTO.getIdTask())) {
            TaskEntity task = taskMapper.toTaskEntity(taskDTO);
            TaskEntity updatedTask = this.taskService.save(task);
            return ResponseEntity.ok(taskMapper.toTaskDTO(updatedTask));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("delete/{taskId}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer taskId) {
        if(this.taskService.exists(taskId) && this.taskService.get(taskId).getActiveTask()) {
            return ResponseEntity.ok(this.taskService.delete(taskId));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("inProgress/beforeDeadLine/{userId}")
    public ResponseEntity<List<TaskDTO>> getTodayTasks(@PathVariable Integer userId) {
        List<TaskDTO> tasks = this.taskService.getTodayTasks(userId).stream()
                .map(taskMapper::toTaskDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(tasks);
    }
}
