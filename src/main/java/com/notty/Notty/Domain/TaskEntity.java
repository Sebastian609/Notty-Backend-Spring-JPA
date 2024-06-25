package com.notty.Notty.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.notty.Notty.Domain.Interfaces.Task;
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
public class TaskEntity extends Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_task", nullable = false)
    private Integer idTask;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user_creator", referencedColumnName = "id_user")
    private UserEntity idUserCreator;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user_owner", referencedColumnName = "id_user")
    private UserEntity userOwner;

    public enum TaskStatus{
        COMPLETED,IN_PROGRESS,CANCELLED,COMPLETED_WHIT_DELAY;
    }






}
