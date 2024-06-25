package com.notty.Notty.Domain.Interfaces;

import com.notty.Notty.Domain.TaskEntity;
import com.notty.Notty.Domain.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class Task {


     @Enumerated(EnumType.STRING)
     @Column(name = "task_status")
     private TaskEntity.TaskStatus taskStatus;

     @Column(length = 50, nullable = false)
     private String name;

     @Column(length = 50, nullable = false)
     private String description;

     @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME")
     private LocalDateTime createrAt;

     @Column(name = "updated_at", nullable = false, columnDefinition = "DATETIME")
     private LocalDateTime updatedAt;

     @Column(name = "time_limit", nullable = false, columnDefinition = "DATETIME")
     private LocalDateTime timeLimit;

     @Column(name = "active_task", nullable = false, columnDefinition = "TINYINT")
     private Boolean activeTask;


}