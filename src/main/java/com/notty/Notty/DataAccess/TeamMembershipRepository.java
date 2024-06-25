package com.notty.Notty.DataAccess;

import com.notty.Notty.Domain.TaskEntity;
import com.notty.Notty.Domain.TeamMembership;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface TeamMembershipRepository extends ListCrudRepository<TeamMembership,Integer> {
    public TeamMembership getById(Integer id);
    public List<TeamMembership> getByUserIdUser(Integer idUser);
}
