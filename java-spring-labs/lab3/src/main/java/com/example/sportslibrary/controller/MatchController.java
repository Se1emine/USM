package com.example.sportslibrary.controller;

import com.example.sportslibrary.dto.CreateMatchDto;
import com.example.sportslibrary.dto.MatchDto;
import com.example.sportslibrary.service.MatchService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/matches")
@CrossOrigin(origins = "*")
public class MatchController {
    
    @Autowired
    private MatchService matchService;
    
    @GetMapping
    public ResponseEntity<List<MatchDto>> getAllMatches() {
        List<MatchDto> matches = matchService.getAllMatches();
        return ResponseEntity.ok(matches);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<MatchDto> getMatchById(@PathVariable Long id) {
        Optional<MatchDto> match = matchService.getMatchById(id);
        return match.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/league/{leagueId}")
    public ResponseEntity<List<MatchDto>> getMatchesByLeagueId(@PathVariable Long leagueId) {
        List<MatchDto> matches = matchService.getMatchesByLeagueId(leagueId);
        return ResponseEntity.ok(matches);
    }
    
    @GetMapping("/team/{teamId}")
    public ResponseEntity<List<MatchDto>> getMatchesByTeamId(@PathVariable Long teamId) {
        List<MatchDto> matches = matchService.getMatchesByTeamId(teamId);
        return ResponseEntity.ok(matches);
    }
    
    @PostMapping
    public ResponseEntity<MatchDto> createMatch(@Valid @RequestBody CreateMatchDto createMatchDto) {
        MatchDto createdMatch = matchService.createMatch(createMatchDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMatch);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<MatchDto> updateMatch(@PathVariable Long id, 
                                               @Valid @RequestBody CreateMatchDto updateMatchDto) {
        try {
            MatchDto updatedMatch = matchService.updateMatch(id, updateMatchDto);
            return ResponseEntity.ok(updatedMatch);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long id) {
        try {
            matchService.deleteMatch(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
