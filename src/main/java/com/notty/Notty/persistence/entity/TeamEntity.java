package com.notty.Notty.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "team")
@Getter
@Setter
@NoArgsConstructor
public class TeamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_team",nullable = false)
    private Integer idTask;
    @Column(length = 30,nullable = false)
    private String name;
    @Column(name = "created_at",nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime createrAt;
    @Column(name = "active_team",nullable = false, columnDefinition = "TINYINT")
    private Boolean activeTeam;
}
