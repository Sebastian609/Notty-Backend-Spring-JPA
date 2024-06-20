package com.notty.Notty.Infraestructure.Mapper;

import com.notty.Notty.Domain.DTO.TaskDTO;
import com.notty.Notty.Domain.TaskEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface TaskMapper {

    @Mappings({
            @Mapping(source = "idTask", target = "idTask"),
            @Mapping(source = "idUserCreator", target = "idUserCreator"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "createrAt", target = "createrAt"),
            @Mapping(source = "updatedAt", target = "updatedAt"),
            @Mapping(source = "timeLimit", target = "timeLimit"),
            @Mapping(source = "activeTask", target = "activeTask"),
            @Mapping(source = "userOwner", target = "userOwner"),
            @Mapping(source = "taskStatus", target = "taskStatus")
    })
    TaskDTO toTaskDTO(TaskEntity taskEntity);

    List<TaskDTO> toTasksDTOs(List<TaskEntity> tasks);

    @InheritInverseConfiguration
    @Mapping(target = "taskStatus", ignore = false)
    TaskEntity toTaskEntity(TaskDTO taskDTO);
}
