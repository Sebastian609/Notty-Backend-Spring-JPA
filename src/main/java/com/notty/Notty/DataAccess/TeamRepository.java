package com.notty.Notty.DataAccess;

import com.notty.Notty.Domain.TeamEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface TeamRepository extends ListCrudRepository<TeamEntity,Integer> {
}
