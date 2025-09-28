package com.football.leaguemanagement.controller;

import com.football.leaguemanagement.dto.CoachDTO;
import com.football.leaguemanagement.service.CoachService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coaches")
@CrossOrigin(origins = "*")
public class CoachController {

    private final CoachService coachService;

    @Autowired
    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping
    public ResponseEntity<List<CoachDTO>> getAllCoaches() {
        List<CoachDTO> coaches = coachService.getAllCoaches();
        return ResponseEntity.ok(coaches);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoachDTO> getCoachById(@PathVariable Long id) {
        return coachService.getCoachById(id)
                .map(coach -> ResponseEntity.ok(coach))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<CoachDTO> getCoachByName(@PathVariable String name) {
        return coachService.getCoachByName(name)
                .map(coach -> ResponseEntity.ok(coach))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nationality/{nationality}")
    public ResponseEntity<List<CoachDTO>> getCoachesByNationality(@PathVariable String nationality) {
        List<CoachDTO> coaches = coachService.getCoachesByNationality(nationality);
        return ResponseEntity.ok(coaches);
    }

    @GetMapping("/experience/{minExperience}")
    public ResponseEntity<List<CoachDTO>> getCoachesByMinimumExperience(@PathVariable int minExperience) {
        List<CoachDTO> coaches = coachService.getCoachesByMinimumExperience(minExperience);
        return ResponseEntity.ok(coaches);
    }

    @GetMapping("/age-range")
    public ResponseEntity<List<CoachDTO>> getCoachesByAgeRange(
            @RequestParam int minAge, 
            @RequestParam int maxAge) {
        List<CoachDTO> coaches = coachService.getCoachesByAgeRange(minAge, maxAge);
        return ResponseEntity.ok(coaches);
    }

    @GetMapping("/available")
    public ResponseEntity<List<CoachDTO>> getAvailableCoaches() {
        List<CoachDTO> coaches = coachService.getAvailableCoaches();
        return ResponseEntity.ok(coaches);
    }

    @GetMapping("/with-teams")
    public ResponseEntity<List<CoachDTO>> getCoachesWithTeams() {
        List<CoachDTO> coaches = coachService.getCoachesWithTeams();
        return ResponseEntity.ok(coaches);
    }

    @PostMapping
    public ResponseEntity<CoachDTO> createCoach(@Valid @RequestBody CoachDTO coachDTO) {
        try {
            CoachDTO createdCoach = coachService.createCoach(coachDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCoach);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CoachDTO> updateCoach(@PathVariable Long id, @Valid @RequestBody CoachDTO coachDTO) {
        try {
            return coachService.updateCoach(id, coachDTO)
                    .map(updatedCoach -> ResponseEntity.ok(updatedCoach))
                    .orElse(ResponseEntity.notFound().build());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoach(@PathVariable Long id) {
        if (coachService.deleteCoach(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/exists")
    public ResponseEntity<Boolean> existsById(@PathVariable Long id) {
        boolean exists = coachService.existsById(id);
        return ResponseEntity.ok(exists);
    }
}
