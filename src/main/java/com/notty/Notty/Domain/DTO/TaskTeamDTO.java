package com.notty.Notty.Domain.DTO;

import com.notty.Notty.Domain.TaskEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TaskTeamDTO extends TaskDTO {
    private Integer idTeamTask;


}
