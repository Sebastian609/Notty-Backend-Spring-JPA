package com.notty.Notty.web.controller;

import com.notty.Notty.persistence.entity.TeamEntity;
import com.notty.Notty.service.TaskService;
import com.notty.Notty.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<List<TeamEntity>> getAll(){
        return ResponseEntity.ok(this.teamService.getAll());
    }
}
