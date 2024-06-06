package com.notty.Notty.Domain.DTO;

import com.notty.Notty.Domain.TeamMembership;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
public class TeamDTO {
    private Integer idTeam;
    private String name;
    private LocalDateTime createdAt;


}
