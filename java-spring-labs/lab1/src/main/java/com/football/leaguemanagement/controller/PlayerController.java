package com.football.leaguemanagement.controller;

import com.football.leaguemanagement.dto.PlayerDTO;
import com.football.leaguemanagement.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@CrossOrigin(origins = "*")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public ResponseEntity<List<PlayerDTO>> getAllPlayers() {
        List<PlayerDTO> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDTO> getPlayerById(@PathVariable Long id) {
        return playerService.getPlayerById(id)
                .map(player -> ResponseEntity.ok(player))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/team/{teamId}")
    public ResponseEntity<List<PlayerDTO>> getPlayersByTeam(@PathVariable Long teamId) {
        List<PlayerDTO> players = playerService.getPlayersByTeam(teamId);
        return ResponseEntity.ok(players);
    }

    @GetMapping("/position/{position}")
    public ResponseEntity<List<PlayerDTO>> getPlayersByPosition(@PathVariable String position) {
        List<PlayerDTO> players = playerService.getPlayersByPosition(position);
        return ResponseEntity.ok(players);
    }

    @GetMapping("/nationality/{nationality}")
    public ResponseEntity<List<PlayerDTO>> getPlayersByNationality(@PathVariable String nationality) {
        List<PlayerDTO> players = playerService.getPlayersByNationality(nationality);
        return ResponseEntity.ok(players);
    }

    @GetMapping("/team/{teamId}/position/{position}")
    public ResponseEntity<List<PlayerDTO>> getPlayersByTeamAndPosition(
            @PathVariable Long teamId, 
            @PathVariable String position) {
        List<PlayerDTO> players = playerService.getPlayersByTeamAndPosition(teamId, position);
        return ResponseEntity.ok(players);
    }

    @GetMapping("/top-scorers")
    public ResponseEntity<List<PlayerDTO>> getTopScorers(@RequestParam(defaultValue = "1") int minGoals) {
        List<PlayerDTO> players = playerService.getTopScorers(minGoals);
        return ResponseEntity.ok(players);
    }

    @GetMapping("/age-range")
    public ResponseEntity<List<PlayerDTO>> getPlayersByAgeRange(
            @RequestParam int minAge, 
            @RequestParam int maxAge) {
        List<PlayerDTO> players = playerService.getPlayersByAgeRange(minAge, maxAge);
        return ResponseEntity.ok(players);
    }

    @PostMapping
    public ResponseEntity<PlayerDTO> createPlayer(@Valid @RequestBody PlayerDTO playerDTO) {
        try {
            PlayerDTO createdPlayer = playerService.createPlayer(playerDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPlayer);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerDTO> updatePlayer(@PathVariable Long id, @Valid @RequestBody PlayerDTO playerDTO) {
        try {
            return playerService.updatePlayer(id, playerDTO)
                    .map(updatedPlayer -> ResponseEntity.ok(updatedPlayer))
                    .orElse(ResponseEntity.notFound().build());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        if (playerService.deletePlayer(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/exists")
    public ResponseEntity<Boolean> existsById(@PathVariable Long id) {
        boolean exists = playerService.existsById(id);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/team/{teamId}/count")
    public ResponseEntity<Long> countPlayersByTeam(@PathVariable Long teamId) {
        long count = playerService.countPlayersByTeam(teamId);
        return ResponseEntity.ok(count);
    }
}
