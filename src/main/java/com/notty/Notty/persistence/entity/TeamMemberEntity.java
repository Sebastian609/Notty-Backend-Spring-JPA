package com.notty.Notty.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Entity
@IdClass(TeamMemberId.class)
@Table(name = "team_member")
@Getter
@Setter
@NoArgsConstructor
public class TeamMemberEntity {
    @Id
    @Column(name = "id_team",nullable = false)
    private Integer idTeam;
    @Id
    @Column(name = "id_member",nullable = false)
    private Integer idMember;
    @Column(name = "joined_at",nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime joinedAt;
    @Column(name = "active_member",nullable = false, columnDefinition = "TINYINT")
    private Boolean activeMember;

}
