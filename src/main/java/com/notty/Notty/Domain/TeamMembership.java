package com.notty.Notty.Domain;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "team_membership")
@Getter
@Setter
@NoArgsConstructor
public class TeamMembership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    @JsonBackReference
    private TeamEntity team;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "active_member", nullable = false, columnDefinition = "TINYINT")
    private Boolean isActive;

    @Column(name = "is_leader", nullable = false, columnDefinition = "TINYINT")
    private Boolean isLeader;
}

