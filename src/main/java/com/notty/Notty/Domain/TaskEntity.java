package com.notty.Notty.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "task")
@Getter
@Setter
@NoArgsConstructor
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_task", nullable = false)
    private Integer idTask;

    @Column(name = "id_user_creator", nullable = false)
    private Integer idUserCreator;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user_owner", referencedColumnName = "id_user")
    private UserEntity userOwner;

    public enum TaskStatus{
        COMPLETED,IN_PROGRESS,CANCELLED,COMPLETED_WHIT_DELAY;
    }






}
