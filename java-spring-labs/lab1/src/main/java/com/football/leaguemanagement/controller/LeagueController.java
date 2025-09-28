package com.football.leaguemanagement.controller;

import com.football.leaguemanagement.dto.LeagueDTO;
import com.football.leaguemanagement.service.LeagueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leagues")
@CrossOrigin(origins = "*")
public class LeagueController {

    private final LeagueService leagueService;

    @Autowired
    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @GetMapping
    public ResponseEntity<List<LeagueDTO>> getAllLeagues() {
        List<LeagueDTO> leagues = leagueService.getAllLeagues();
        return ResponseEntity.ok(leagues);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeagueDTO> getLeagueById(@PathVariable Long id) {
        return leagueService.getLeagueById(id)
                .map(league -> ResponseEntity.ok(league))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<LeagueDTO> getLeagueByName(@PathVariable String name) {
        return leagueService.getLeagueByName(name)
                .map(league -> ResponseEntity.ok(league))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<List<LeagueDTO>> getLeaguesByCountry(@PathVariable String country) {
        List<LeagueDTO> leagues = leagueService.getLeaguesByCountry(country);
        return ResponseEntity.ok(leagues);
    }

    @GetMapping("/season/{season}")
    public ResponseEntity<List<LeagueDTO>> getLeaguesBySeason(@PathVariable Integer season) {
        List<LeagueDTO> leagues = leagueService.getLeaguesBySeason(season);
        return ResponseEntity.ok(leagues);
    }

    @PostMapping
    public ResponseEntity<LeagueDTO> createLeague(@Valid @RequestBody LeagueDTO leagueDTO) {
        try {
            LeagueDTO createdLeague = leagueService.createLeague(leagueDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdLeague);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeagueDTO> updateLeague(@PathVariable Long id, @Valid @RequestBody LeagueDTO leagueDTO) {
        try {
            return leagueService.updateLeague(id, leagueDTO)
                    .map(updatedLeague -> ResponseEntity.ok(updatedLeague))
                    .orElse(ResponseEntity.notFound().build());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeague(@PathVariable Long id) {
        if (leagueService.deleteLeague(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/exists")
    public ResponseEntity<Boolean> existsById(@PathVariable Long id) {
        boolean exists = leagueService.existsById(id);
        return ResponseEntity.ok(exists);
    }
}
