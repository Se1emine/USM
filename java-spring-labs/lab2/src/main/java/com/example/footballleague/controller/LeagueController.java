package com.example.footballleague.controller;

import com.example.footballleague.dto.LeagueDTO;
import com.example.footballleague.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/leagues")
@CrossOrigin(origins = "*")
public class LeagueController {

    @Autowired
    private LeagueService leagueService;

    @PostMapping
    public ResponseEntity<LeagueDTO> createLeague(@Valid @RequestBody LeagueDTO leagueDTO) {
        try {
            LeagueDTO createdLeague = leagueService.createLeague(leagueDTO);
            return new ResponseEntity<>(createdLeague, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeagueDTO> getLeagueById(@PathVariable Long id) {
        try {
            LeagueDTO league = leagueService.getLeagueById(id);
            return new ResponseEntity<>(league, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<LeagueDTO>> getAllLeagues() {
        try {
            List<LeagueDTO> leagues = leagueService.getAllLeagues();
            return new ResponseEntity<>(leagues, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeagueDTO> updateLeague(@PathVariable Long id, @Valid @RequestBody LeagueDTO leagueDTO) {
        try {
            LeagueDTO updatedLeague = leagueService.updateLeague(id, leagueDTO);
            return new ResponseEntity<>(updatedLeague, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeague(@PathVariable Long id) {
        try {
            leagueService.deleteLeague(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search/name/{name}")
    public ResponseEntity<LeagueDTO> getLeagueByName(@PathVariable String name) {
        try {
            LeagueDTO league = leagueService.getLeagueByName(name);
            return new ResponseEntity<>(league, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search/country/{country}")
    public ResponseEntity<List<LeagueDTO>> getLeaguesByCountry(@PathVariable String country) {
        try {
            List<LeagueDTO> leagues = leagueService.getLeaguesByCountry(country);
            return new ResponseEntity<>(leagues, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/with-teams")
    public ResponseEntity<List<LeagueDTO>> getLeaguesWithTeams() {
        try {
            List<LeagueDTO> leagues = leagueService.getLeaguesWithTeams();
            return new ResponseEntity<>(leagues, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
