package com.example.sportslibrary.controller;

import com.example.sportslibrary.dto.CreatePlayerDto;
import com.example.sportslibrary.dto.PlayerDto;
import com.example.sportslibrary.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/players")
@CrossOrigin(origins = "*")
public class PlayerController {
    
    @Autowired
    private PlayerService playerService;
    
    @GetMapping
    public ResponseEntity<List<PlayerDto>> getAllPlayers() {
        List<PlayerDto> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PlayerDto> getPlayerById(@PathVariable Long id) {
        Optional<PlayerDto> player = playerService.getPlayerById(id);
        return player.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/team/{teamId}")
    public ResponseEntity<List<PlayerDto>> getPlayersByTeamId(@PathVariable Long teamId) {
        List<PlayerDto> players = playerService.getPlayersByTeamId(teamId);
        return ResponseEntity.ok(players);
    }
    
    @PostMapping
    public ResponseEntity<PlayerDto> createPlayer(@Valid @RequestBody CreatePlayerDto createPlayerDto) {
        PlayerDto createdPlayer = playerService.createPlayer(createPlayerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlayer);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PlayerDto> updatePlayer(@PathVariable Long id, 
                                                 @Valid @RequestBody CreatePlayerDto updatePlayerDto) {
        try {
            PlayerDto updatedPlayer = playerService.updatePlayer(id, updatePlayerDto);
            return ResponseEntity.ok(updatedPlayer);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        try {
            playerService.deletePlayer(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
