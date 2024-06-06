package com.notty.Notty.Aplication;

import com.notty.Notty.Domain.TeamEntity;
import com.notty.Notty.DataAccess.TeamRepository;
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
