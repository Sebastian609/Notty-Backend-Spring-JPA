package com.notty.Notty.Aplication;

import com.notty.Notty.DataAccess.TeamMembershipRepository;
import com.notty.Notty.Domain.TeamMembership;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamMembershipService {
    private final TeamMembershipRepository teamMembershipRepository;

    public TeamMembershipService(TeamMembershipRepository teamMembershipRepository) {
        this.teamMembershipRepository = teamMembershipRepository;
    }

    public List<TeamMembership> getByUserId(int userId){
        return teamMembershipRepository.getByUserIdUser(userId);
    }

    public TeamMembership getById(Integer idMembership){
        return teamMembershipRepository.getById(idMembership);
    }
}

