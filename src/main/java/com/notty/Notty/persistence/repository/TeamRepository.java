package com.notty.Notty.persistence.repository;

import com.notty.Notty.persistence.entity.TeamEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface TeamRepository extends ListCrudRepository<TeamEntity,Integer> {
}
