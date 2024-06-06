package com.notty.Notty.Presentation;

import com.notty.Notty.Domain.DTO.TeamDTO;
import com.notty.Notty.Aplication.TeamService;
import com.notty.Notty.Infraestructure.Mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService teamService;
    private final TeamMapper teamMapper;

    @Autowired
    public TeamController(TeamService teamService, TeamMapper teamMapper) {
        this.teamService = teamService;
        this.teamMapper = teamMapper;
    }

    @GetMapping
    public ResponseEntity<List<TeamDTO>> getAll() {
        List<TeamDTO> teamDTOs = teamService.getAll().stream()
                .map(teamMapper::TeamToTeamDTO) // Aplicar mapeo de TeamEntity a TeamDTO
                .collect(Collectors.toList());

        return ResponseEntity.ok(teamDTOs);
    }
}
