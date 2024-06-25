package com.notty.Notty.Infraestructure.Mapper;

import com.notty.Notty.Domain.DTO.TeamMembershipDTO;
import com.notty.Notty.Domain.TeamMembership;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamMembershipMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "isActive", target = "isActive"),
            @Mapping(source = "isLeader", target = "isLeader"),
            @Mapping(source = "team", target = "team"),
            @Mapping(source = "teamTasks",target = "teamTasks")
    })
    TeamMembershipDTO toTeamMembershipDTO(TeamMembership membership);

    List<TeamMembershipDTO> toTeamMembershipDTOs(List<TeamMembership> memberships);

    @InheritInverseConfiguration
    @Mapping(target = "user", ignore = true)
    TeamMembership toTeamMembershipEntity(TeamMembershipDTO membershipDTO);

    List<TeamMembership> toTeamMembershipEntities(List<TeamMembershipDTO> membershipDTOs);
}
