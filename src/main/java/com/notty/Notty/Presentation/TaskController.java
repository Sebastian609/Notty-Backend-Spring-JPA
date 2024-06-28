package com.notty.Notty.Presentation;

import com.notty.Notty.Aplication.Factory.TaskFactory;
import com.notty.Notty.Aplication.TaskTeamService;
import com.notty.Notty.Domain.DTO.GenericTaskDTO;
import com.notty.Notty.Domain.DTO.PersonalTaskDTO;
import com.notty.Notty.Domain.DTO.TaskDTO;
import com.notty.Notty.Domain.DTO.TaskTeamDTO;
import com.notty.Notty.Domain.Interfaces.Task;
import com.notty.Notty.Domain.TaskEntity;
import com.notty.Notty.Aplication.TaskService;
import com.notty.Notty.Domain.TeamTaskEntity;
import com.notty.Notty.Infraestructure.Mapper.TaskMapper;
import com.notty.Notty.Infraestructure.Mapper.TaskTeamMapper;
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
    private final TaskTeamService taskTeamService;
    private final TaskMapper taskMapper;
    private final TaskTeamMapper taskTeamMapper;


    @Autowired
    public TaskController(TaskService taskService, TaskTeamService taskTeamService, TaskMapper taskMapper, TaskTeamMapper taskTeamMapper) {
        this.taskService = taskService;
        this.taskTeamService = taskTeamService;
        this.taskMapper = taskMapper;

        this.taskTeamMapper = taskTeamMapper;
    }

    @GetMapping
    public ResponseEntity<List<PersonalTaskDTO>> getAll() {
        List<PersonalTaskDTO> tasks = this.taskService.getAll().stream()
                .map(taskMapper::toTaskDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(tasks);
    }



    @PostMapping
    public ResponseEntity<TaskDTO> save(@RequestBody GenericTaskDTO genericDTO) {
        if (genericDTO.getIdTask() != null) {
            return ResponseEntity.badRequest().build();
        }

        System.out.println(genericDTO);
        TaskDTO newTaskDTO = TaskFactory.createTask(genericDTO);
        if (newTaskDTO == null) {
            return ResponseEntity.badRequest().build();
        }

        Task task = convertToTaskEntity(newTaskDTO);
        if (task == null) {
            return ResponseEntity.badRequest().build();
        }

        task.setTaskStatus(TaskEntity.TaskStatus.IN_PROGRESS);
        task.setCreaterAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());

        if (task instanceof TaskEntity) {
            TaskEntity savedTask = this.taskService.save((TaskEntity) task);
            return ResponseEntity.ok(taskMapper.toTaskDTO(savedTask));
        }

        if (task instanceof TeamTaskEntity) {
            TeamTaskEntity savedTask = this.taskTeamService.save((TeamTaskEntity) task);
            return ResponseEntity.ok(taskTeamMapper.toTaskTeamDTO(savedTask));
        }

        return ResponseEntity.badRequest().build();
    }

    private Task convertToTaskEntity(TaskDTO taskDTO) {
        if (taskDTO instanceof PersonalTaskDTO) {
            return taskMapper.toTaskEntity((PersonalTaskDTO) taskDTO);
        }

        if (taskDTO instanceof TaskTeamDTO) {
            return taskTeamMapper.toTeamTaskEntity((TaskTeamDTO) taskDTO);
        }

        return null;
    }


    @GetMapping("changeStatus/{taskId}")
    public ResponseEntity<PersonalTaskDTO> changeStatus(@PathVariable Integer taskId) {
        if(this.taskService.exists(taskId)) {
            TaskEntity updatedTask = this.taskService.changeTaskStatus(taskId);
            return ResponseEntity.ok(taskMapper.toTaskDTO(updatedTask));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("owner/{ownerId}")
    public ResponseEntity<List<PersonalTaskDTO>> getByOwnerId(@PathVariable Integer ownerId) {
        List<PersonalTaskDTO> tasks = this.taskService.getByOwnerId(ownerId).stream()
                .map(taskMapper::toTaskDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("owner/activeTasks/{ownerId}")
    public ResponseEntity<List<PersonalTaskDTO>> getActiveTasksByOwnerID(@PathVariable Integer ownerId) {
        List<PersonalTaskDTO> tasks = this.taskService.getAllActiveTasksByOwner(ownerId).stream()
                .map(taskMapper::toTaskDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(tasks);
    }

    @PutMapping
    public ResponseEntity<TaskDTO> update(@RequestBody GenericTaskDTO genericDTO) {

        if (genericDTO.getIdTask() != null && this.taskService.exists(genericDTO.getIdTask())) {

            TaskDTO newTaskDTO = TaskFactory.createTask(genericDTO);
            if (newTaskDTO == null) {
                return ResponseEntity.badRequest().build();
            }
            // Convertir TaskDTO a la entidad correspondiente usando Strategy Pattern
            Task task = convertToTaskEntity(newTaskDTO);
            if (task == null) {
                return ResponseEntity.badRequest().build();
            }

            if (task instanceof TaskEntity) {
               ((TaskEntity) task).setIdTask(genericDTO.getIdTask());
                TaskEntity updatedTask = this.taskService.save((TaskEntity) task);

                return ResponseEntity.ok(taskMapper.toTaskDTO(updatedTask));
            }

            if (task instanceof TeamTaskEntity) {
                ((TaskEntity) task).setIdTask(genericDTO.getIdTaskTeam());
                TeamTaskEntity updatedTask = this.taskTeamService.save((TeamTaskEntity) task);
                updatedTask.setIdTeamTask(genericDTO.getIdTaskTeam());
                return ResponseEntity.ok(taskTeamMapper.toTaskTeamDTO(updatedTask));
            }
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
    public ResponseEntity<List<PersonalTaskDTO>> getTodayTasks(@PathVariable Integer userId) {
        List<PersonalTaskDTO> tasks = this.taskService.getTodayTasks(userId).stream()
                .map(taskMapper::toTaskDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(tasks);
    }
}
