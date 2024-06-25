package com.notty.Notty.Presentation;

import com.notty.Notty.Aplication.TeamMembershipService;
import com.notty.Notty.Domain.DTO.TaskTeamDTO;
import com.notty.Notty.Domain.DTO.TeamMembershipDTO;
import com.notty.Notty.Domain.TeamMembership;
import com.notty.Notty.Infraestructure.Mapper.TeamMembershipMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/memberships")
public class TeamMembershipController {
    private final TeamMembershipService teamMembershipService;
    private final TeamMembershipMapper teamMembershipMapper;

    public TeamMembershipController(TeamMembershipService teamMembershipService, TeamMembershipMapper teamMembershipMapper) {
        this.teamMembershipService = teamMembershipService;
        this.teamMembershipMapper = teamMembershipMapper;
    }

    @GetMapping("/{idMembership}")
    public ResponseEntity<TeamMembershipDTO> getById(@PathVariable int idMembership){
       try {
            TeamMembership membership = teamMembershipService.getById(idMembership);
            TeamMembershipDTO membershipDTO = teamMembershipMapper.toTeamMembershipDTO(membership);
            return ResponseEntity.ok(membershipDTO);
       }catch (Exception ex){
          return ResponseEntity.badRequest().build();
       }
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<List<TeamMembershipDTO>> getByUserId(@PathVariable int userId){
        try {
            List<TeamMembership> memberships = teamMembershipService.getByUserId(userId);
            List<TeamMembershipDTO> membershipDTOs = memberships.stream()
                    .map(teamMembershipMapper::toTeamMembershipDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(membershipDTOs);
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }
}
