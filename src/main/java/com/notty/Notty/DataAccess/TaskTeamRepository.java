package com.notty.Notty.DataAccess;

import com.notty.Notty.Domain.TeamMembership;
import com.notty.Notty.Domain.TeamTaskEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface TaskTeamRepository extends ListCrudRepository<TeamTaskEntity,Integer> {
}
