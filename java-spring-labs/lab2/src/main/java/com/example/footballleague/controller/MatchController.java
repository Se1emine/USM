package com.example.footballleague.controller;

import com.example.footballleague.dto.MatchDTO;
import com.example.footballleague.entity.Match;
import com.example.footballleague.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/matches")
@CrossOrigin(origins = "*")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping
    public ResponseEntity<MatchDTO> createMatch(@Valid @RequestBody MatchDTO matchDTO) {
        try {
            MatchDTO createdMatch = matchService.createMatch(matchDTO);
            return new ResponseEntity<>(createdMatch, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchDTO> getMatchById(@PathVariable Long id) {
        try {
            MatchDTO match = matchService.getMatchById(id);
            return new ResponseEntity<>(match, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<MatchDTO>> getAllMatches() {
        try {
            List<MatchDTO> matches = matchService.getAllMatches();
            return new ResponseEntity<>(matches, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatchDTO> updateMatch(@PathVariable Long id, @Valid @RequestBody MatchDTO matchDTO) {
        try {
            MatchDTO updatedMatch = matchService.updateMatch(id, matchDTO);
            return new ResponseEntity<>(updatedMatch, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long id) {
        try {
            matchService.deleteMatch(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search/team/{teamId}")
    public ResponseEntity<List<MatchDTO>> getMatchesByTeam(@PathVariable Long teamId) {
        try {
            List<MatchDTO> matches = matchService.getMatchesByTeam(teamId);
            return new ResponseEntity<>(matches, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search/league/{leagueId}")
    public ResponseEntity<List<MatchDTO>> getMatchesByLeague(@PathVariable Long leagueId) {
        try {
            List<MatchDTO> matches = matchService.getMatchesByLeague(leagueId);
            return new ResponseEntity<>(matches, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search/status/{status}")
    public ResponseEntity<List<MatchDTO>> getMatchesByStatus(@PathVariable Match.MatchStatus status) {
        try {
            List<MatchDTO> matches = matchService.getMatchesByStatus(status);
            return new ResponseEntity<>(matches, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search/date-range")
    public ResponseEntity<List<MatchDTO>> getMatchesByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        try {
            List<MatchDTO> matches = matchService.getMatchesByDateRange(startDate, endDate);
            return new ResponseEntity<>(matches, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/upcoming")
    public ResponseEntity<List<MatchDTO>> getUpcomingMatches() {
        try {
            List<MatchDTO> matches = matchService.getUpcomingMatches();
            return new ResponseEntity<>(matches, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/finished")
    public ResponseEntity<List<MatchDTO>> getFinishedMatches() {
        try {
            List<MatchDTO> matches = matchService.getFinishedMatches();
            return new ResponseEntity<>(matches, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search/between-teams")
    public ResponseEntity<List<MatchDTO>> getMatchesBetweenTeams(
            @RequestParam Long homeTeamId, 
            @RequestParam Long awayTeamId) {
        try {
            List<MatchDTO> matches = matchService.getMatchesBetweenTeams(homeTeamId, awayTeamId);
            return new ResponseEntity<>(matches, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/{id}/score")
    public ResponseEntity<MatchDTO> updateMatchScore(
            @PathVariable Long id,
            @RequestParam int homeScore,
            @RequestParam int awayScore) {
        try {
            MatchDTO updatedMatch = matchService.updateMatchScore(id, homeScore, awayScore);
            return new ResponseEntity<>(updatedMatch, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
