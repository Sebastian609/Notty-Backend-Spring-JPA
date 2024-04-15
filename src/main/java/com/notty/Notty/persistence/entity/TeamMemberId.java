package com.notty.Notty.persistence.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;


public class TeamMemberId  implements Serializable {
    private Integer idTeam;
    private Integer idMember;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeamMemberId that)) return false;
        return Objects.equals(idTeam, that.idTeam) && Objects.equals(idMember, that.idMember);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTeam, idMember);
    }
}
