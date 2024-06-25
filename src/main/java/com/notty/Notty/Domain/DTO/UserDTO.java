package com.notty.Notty.Domain.DTO;

import com.notty.Notty.Domain.TeamMembership;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class UserDTO {
    private Integer idUser;
    private String name;
    private String firstLastName;
    private String secondLastName;
}
