package com.notty.Notty.persistence.entity;

import com.notty.Notty.persistence.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "team")
@Getter
@Setter
@NoArgsConstructor
public class TeamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_team", nullable = false)
    private Integer idTeam;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime createdAt;

    @Column(name = "active_team", nullable = false, columnDefinition = "TINYINT")
    private Boolean activeTeam;

    @ManyToMany
    @JoinTable(name = "team_members",
            joinColumns = @JoinColumn(name = "id_team"),
            inverseJoinColumns = @JoinColumn(name = "id_user"))
    private List<UserEntity> teamMembers;
}
