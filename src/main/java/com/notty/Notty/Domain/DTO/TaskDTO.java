package com.notty.Notty.Domain.DTO;

import com.notty.Notty.Domain.TaskEntity;
import com.notty.Notty.Domain.TeamMembership;
import com.notty.Notty.Domain.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
public class TaskDTO {
    private Integer idTask;
    private Integer idUserCreator;
    private String name;
    private String description;
    private LocalDateTime createrAt;
    private LocalDateTime updatedAt;
    private LocalDateTime timeLimit;
    private Boolean activeTask;
    private UserDTO userOwner;
    private TaskEntity.TaskStatus taskStatus;
}
