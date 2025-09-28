package com.example.footballleague.controller;

import com.example.footballleague.dto.TeamDTO;
import com.example.footballleague.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/teams")
@CrossOrigin(origins = "*")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping
    public ResponseEntity<TeamDTO> createTeam(@Valid @RequestBody TeamDTO teamDTO) {
        try {
            TeamDTO createdTeam = teamService.createTeam(teamDTO);
            return new ResponseEntity<>(createdTeam, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDTO> getTeamById(@PathVariable Long id) {
        try {
            TeamDTO team = teamService.getTeamById(id);
            return new ResponseEntity<>(team, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<TeamDTO>> getAllTeams() {
        try {
            List<TeamDTO> teams = teamService.getAllTeams();
            return new ResponseEntity<>(teams, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamDTO> updateTeam(@PathVariable Long id, @Valid @RequestBody TeamDTO teamDTO) {
        try {
            TeamDTO updatedTeam = teamService.updateTeam(id, teamDTO);
            return new ResponseEntity<>(updatedTeam, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        try {
            teamService.deleteTeam(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search/name/{name}")
    public ResponseEntity<TeamDTO> getTeamByName(@PathVariable String name) {
        try {
            TeamDTO team = teamService.getTeamByName(name);
            return new ResponseEntity<>(team, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search/city/{city}")
    public ResponseEntity<List<TeamDTO>> getTeamsByCity(@PathVariable String city) {
        try {
            List<TeamDTO> teams = teamService.getTeamsByCity(city);
            return new ResponseEntity<>(teams, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search/league/{leagueId}")
    public ResponseEntity<List<TeamDTO>> getTeamsByLeague(@PathVariable Long leagueId) {
        try {
            List<TeamDTO> teams = teamService.getTeamsByLeague(leagueId);
            return new ResponseEntity<>(teams, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/with-players")
    public ResponseEntity<List<TeamDTO>> getTeamsWithPlayers() {
        try {
            List<TeamDTO> teams = teamService.getTeamsWithPlayers();
            return new ResponseEntity<>(teams, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/with-coach")
    public ResponseEntity<List<TeamDTO>> getTeamsWithCoach() {
        try {
            List<TeamDTO> teams = teamService.getTeamsWithCoach();
            return new ResponseEntity<>(teams, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
