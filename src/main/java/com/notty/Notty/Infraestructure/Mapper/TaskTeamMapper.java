package com.notty.Notty.Infraestructure.Mapper;


import com.notty.Notty.Domain.DTO.TaskDTO;
import com.notty.Notty.Domain.DTO.TaskTeamDTO;
import com.notty.Notty.Domain.TeamTaskEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface TaskTeamMapper {

    @Mappings({
            @Mapping(source = "idTeamTask", target = "idTeamTask"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "createrAt", target = "createrAt"),
            @Mapping(source = "updatedAt", target = "updatedAt"),
            @Mapping(source = "timeLimit", target = "timeLimit"),
            @Mapping(source = "activeTask", target = "activeTask"),
            @Mapping(source = "taskStatus", target = "taskStatus")


    })
    TaskTeamDTO toTaskTeamDTO(TeamTaskEntity teamTaskEntity);

    List<TaskTeamDTO> toTaskTeamDTOs(List<TeamTaskEntity> teamTasks);

    @InheritInverseConfiguration
    @Mapping(target = "teamMembership",ignore=true)
    TeamTaskEntity toTeamTaskEntity(TaskTeamDTO taskDTO);
}
