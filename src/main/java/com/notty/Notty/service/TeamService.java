package com.notty.Notty.service;

import com.notty.Notty.persistence.entity.TeamEntity;
import com.notty.Notty.persistence.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {


    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<TeamEntity> getAll(){
        return this.teamRepository.findAll();
    }
}
