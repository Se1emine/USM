package com.football.leaguemanagement.controller;

import com.football.leaguemanagement.dto.TeamDTO;
import com.football.leaguemanagement.service.TeamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
@CrossOrigin(origins = "*")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<List<TeamDTO>> getAllTeams() {
        List<TeamDTO> teams = teamService.getAllTeams();
        return ResponseEntity.ok(teams);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDTO> getTeamById(@PathVariable Long id) {
        return teamService.getTeamById(id)
                .map(team -> ResponseEntity.ok(team))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<TeamDTO> getTeamByName(@PathVariable String name) {
        return teamService.getTeamByName(name)
                .map(team -> ResponseEntity.ok(team))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<TeamDTO>> getTeamsByCity(@PathVariable String city) {
        List<TeamDTO> teams = teamService.getTeamsByCity(city);
        return ResponseEntity.ok(teams);
    }

    @GetMapping("/league/{leagueId}")
    public ResponseEntity<List<TeamDTO>> getTeamsByLeague(@PathVariable Long leagueId) {
        List<TeamDTO> teams = teamService.getTeamsByLeague(leagueId);
        return ResponseEntity.ok(teams);
    }

    @PostMapping
    public ResponseEntity<TeamDTO> createTeam(@Valid @RequestBody TeamDTO teamDTO) {
        try {
            TeamDTO createdTeam = teamService.createTeam(teamDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTeam);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamDTO> updateTeam(@PathVariable Long id, @Valid @RequestBody TeamDTO teamDTO) {
        try {
            return teamService.updateTeam(id, teamDTO)
                    .map(updatedTeam -> ResponseEntity.ok(updatedTeam))
                    .orElse(ResponseEntity.notFound().build());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        if (teamService.deleteTeam(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/exists")
    public ResponseEntity<Boolean> existsById(@PathVariable Long id) {
        boolean exists = teamService.existsById(id);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/league/{leagueId}/count")
    public ResponseEntity<Long> countTeamsByLeague(@PathVariable Long leagueId) {
        long count = teamService.countTeamsByLeague(leagueId);
        return ResponseEntity.ok(count);
    }
}
