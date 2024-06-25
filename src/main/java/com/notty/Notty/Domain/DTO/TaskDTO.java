package com.notty.Notty.Domain.DTO;

import com.notty.Notty.Domain.TaskEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TaskDTO {
    private String name;
    private String description;
    private LocalDateTime createrAt;
    private LocalDateTime updatedAt;
    private LocalDateTime timeLimit;
    private Boolean activeTask;
    private TaskEntity.TaskStatus taskStatus;
}
