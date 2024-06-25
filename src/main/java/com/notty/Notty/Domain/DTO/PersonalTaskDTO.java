package com.notty.Notty.Domain.DTO;

import com.notty.Notty.Domain.TaskEntity;
import com.notty.Notty.Domain.TeamMembership;
import com.notty.Notty.Domain.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
public class PersonalTaskDTO extends TaskDTO {
    private Integer idTask;
    private UserDTO idUserCreator;
    private UserDTO userOwner;

}
