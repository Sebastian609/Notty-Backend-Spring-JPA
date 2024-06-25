package com.notty.Notty.Infraestructure.Mapper;

import com.notty.Notty.Domain.DTO.TeamDTO;
import com.notty.Notty.Domain.TeamEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    @Mappings({
            @Mapping(source = "idTeam", target = "idTeam"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "createdAt", target = "createdAt"),


    })
    TeamDTO TeamToTeamDTO(TeamEntity teamEntity);

    List<TeamDTO> toTeamsDTOs(List<TeamEntity> teams);

    @InheritInverseConfiguration
    @Mapping( target = "teamMemberships",ignore=true)
    TeamEntity toTeamEntity(TeamDTO teamDTO);
}
