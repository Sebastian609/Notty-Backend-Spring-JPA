package com.notty.Notty.Domain.DTO;

import com.notty.Notty.Domain.TeamEntity;
import com.notty.Notty.Domain.TeamTaskEntity;
import com.notty.Notty.Domain.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TeamMembershipDTO {
    private Integer id;
    private Boolean isActive;
    private Boolean isLeader;
    private TeamDTO team;
    private List<TaskTeamDTO> teamTasks;
}


