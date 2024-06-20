package com.notty.Notty.Infraestructure.Mapper;

import com.notty.Notty.Domain.DTO.TeamDTO;
import com.notty.Notty.Domain.DTO.UserDTO;
import com.notty.Notty.Domain.TeamEntity;
import com.notty.Notty.Domain.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(source = "idUser", target = "idUser"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "firstLastName", target = "firstLastName"),
            @Mapping(source = "secondLastName", target = "secondLastName"),
    })
    UserDTO UserToUserDTO(UserEntity userEntity);

    List<UserDTO> toUsersDTOs(List<UserEntity> users);

    @InheritInverseConfiguration
    @Mapping(target = "mail", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "phone", ignore = true)
    @Mapping(target = "birthday", ignore = true)
    @Mapping(target = "signInAt", ignore = true)
    @Mapping(target = "activeUser", ignore = true)
    @Mapping(target = "teamMemberships", ignore = true)
    @Mapping(target = "personalTasks", ignore = true)
    @Mapping(target = "roles", ignore = true)
    UserEntity toUserEntity(UserDTO userDTO);

}
