package com.example.footballleague.controller;

import com.example.footballleague.dto.CoachDTO;
import com.example.footballleague.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/coaches")
@CrossOrigin(origins = "*")
public class CoachController {

    @Autowired
    private CoachService coachService;

    @PostMapping
    public ResponseEntity<CoachDTO> createCoach(@Valid @RequestBody CoachDTO coachDTO) {
        try {
            CoachDTO createdCoach = coachService.createCoach(coachDTO);
            return new ResponseEntity<>(createdCoach, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoachDTO> getCoachById(@PathVariable Long id) {
        try {
            CoachDTO coach = coachService.getCoachById(id);
            return new ResponseEntity<>(coach, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<CoachDTO>> getAllCoaches() {
        try {
            List<CoachDTO> coaches = coachService.getAllCoaches();
            return new ResponseEntity<>(coaches, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CoachDTO> updateCoach(@PathVariable Long id, @Valid @RequestBody CoachDTO coachDTO) {
        try {
            CoachDTO updatedCoach = coachService.updateCoach(id, coachDTO);
            return new ResponseEntity<>(updatedCoach, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoach(@PathVariable Long id) {
        try {
            coachService.deleteCoach(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search/nationality/{nationality}")
    public ResponseEntity<List<CoachDTO>> getCoachesByNationality(@PathVariable String nationality) {
        try {
            List<CoachDTO> coaches = coachService.getCoachesByNationality(nationality);
            return new ResponseEntity<>(coaches, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search/experience/{minYears}")
    public ResponseEntity<List<CoachDTO>> getCoachesByExperience(@PathVariable int minYears) {
        try {
            List<CoachDTO> coaches = coachService.getCoachesByExperience(minYears);
            return new ResponseEntity<>(coaches, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/without-team")
    public ResponseEntity<List<CoachDTO>> getCoachesWithoutTeam() {
        try {
            List<CoachDTO> coaches = coachService.getCoachesWithoutTeam();
            return new ResponseEntity<>(coaches, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search/name")
    public ResponseEntity<List<CoachDTO>> getCoachesByFullName(
            @RequestParam String firstName, 
            @RequestParam String lastName) {
        try {
            List<CoachDTO> coaches = coachService.getCoachesByFullName(firstName, lastName);
            return new ResponseEntity<>(coaches, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
