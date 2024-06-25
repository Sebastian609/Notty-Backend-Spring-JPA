package com.notty.Notty.Domain;

import com.notty.Notty.Domain.Interfaces.Task;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "team_task")
public class TeamTaskEntity extends Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_team_task")
    private Integer idTeamTask;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private TeamMembership teamMembership;
}