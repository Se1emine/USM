package com.football.leaguemanagement.controller;

import com.football.leaguemanagement.dto.MatchDTO;
import com.football.leaguemanagement.service.MatchService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/matches")
@CrossOrigin(origins = "*")
public class MatchController {

    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping
    public ResponseEntity<List<MatchDTO>> getAllMatches() {
        List<MatchDTO> matches = matchService.getAllMatches();
        return ResponseEntity.ok(matches);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchDTO> getMatchById(@PathVariable Long id) {
        return matchService.getMatchById(id)
                .map(match -> ResponseEntity.ok(match))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/league/{leagueId}")
    public ResponseEntity<List<MatchDTO>> getMatchesByLeague(@PathVariable Long leagueId) {
        List<MatchDTO> matches = matchService.getMatchesByLeague(leagueId);
        return ResponseEntity.ok(matches);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<MatchDTO>> getMatchesByStatus(@PathVariable String status) {
        List<MatchDTO> matches = matchService.getMatchesByStatus(status);
        return ResponseEntity.ok(matches);
    }

    @GetMapping("/round/{round}")
    public ResponseEntity<List<MatchDTO>> getMatchesByRound(@PathVariable Integer round) {
        List<MatchDTO> matches = matchService.getMatchesByRound(round);
        return ResponseEntity.ok(matches);
    }

    @GetMapping("/team/{teamId}")
    public ResponseEntity<List<MatchDTO>> getMatchesByTeam(@PathVariable Long teamId) {
        List<MatchDTO> matches = matchService.getMatchesByTeam(teamId);
        return ResponseEntity.ok(matches);
    }

    @GetMapping("/team/{teamId}/home")
    public ResponseEntity<List<MatchDTO>> getHomeMatchesByTeam(@PathVariable Long teamId) {
        List<MatchDTO> matches = matchService.getHomeMatchesByTeam(teamId);
        return ResponseEntity.ok(matches);
    }

    @GetMapping("/team/{teamId}/away")
    public ResponseEntity<List<MatchDTO>> getAwayMatchesByTeam(@PathVariable Long teamId) {
        List<MatchDTO> matches = matchService.getAwayMatchesByTeam(teamId);
        return ResponseEntity.ok(matches);
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<MatchDTO>> getMatchesByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        List<MatchDTO> matches = matchService.getMatchesByDateRange(startDate, endDate);
        return ResponseEntity.ok(matches);
    }

    @GetMapping("/league/{leagueId}/round/{round}")
    public ResponseEntity<List<MatchDTO>> getMatchesByLeagueAndRound(
            @PathVariable Long leagueId, 
            @PathVariable Integer round) {
        List<MatchDTO> matches = matchService.getMatchesByLeagueAndRound(leagueId, round);
        return ResponseEntity.ok(matches);
    }

    @GetMapping("/between-teams")
    public ResponseEntity<List<MatchDTO>> getMatchesBetweenTeams(
            @RequestParam Long team1Id, 
            @RequestParam Long team2Id) {
        List<MatchDTO> matches = matchService.getMatchesBetweenTeams(team1Id, team2Id);
        return ResponseEntity.ok(matches);
    }

    @PostMapping
    public ResponseEntity<MatchDTO> createMatch(@Valid @RequestBody MatchDTO matchDTO) {
        try {
            MatchDTO createdMatch = matchService.createMatch(matchDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdMatch);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatchDTO> updateMatch(@PathVariable Long id, @Valid @RequestBody MatchDTO matchDTO) {
        try {
            return matchService.updateMatch(id, matchDTO)
                    .map(updatedMatch -> ResponseEntity.ok(updatedMatch))
                    .orElse(ResponseEntity.notFound().build());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long id) {
        if (matchService.deleteMatch(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/exists")
    public ResponseEntity<Boolean> existsById(@PathVariable Long id) {
        boolean exists = matchService.existsById(id);
        return ResponseEntity.ok(exists);
    }
}
