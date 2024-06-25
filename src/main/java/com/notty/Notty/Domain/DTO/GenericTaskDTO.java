package com.notty.Notty.Domain.DTO;

import com.notty.Notty.Domain.TeamMembership;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;



@Getter
@Setter
@NoArgsConstructor
public class GenericTaskDTO extends TaskDTO {
    private String type;
    private Integer idTask;
    private UserDTO idUserCreator;
    private UserDTO userOwner;
    private Integer idTaskTeam;
    private TeamMembershipDTO teamMembershipDTO;

}
