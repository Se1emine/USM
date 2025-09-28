package com.example.sportslibrary.service;

import com.example.sportslibrary.dto.*;
import com.example.sportslibrary.entity.*;
import com.example.sportslibrary.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlayerService {
    
    @Autowired
    private PlayerRepository playerRepository;
    
    @Autowired
    private TeamRepository teamRepository;
    
    public List<PlayerDto> getAllPlayers() {
        List<Player> players = playerRepository.findAll();
        return players.stream().map(this::convertToDto).collect(Collectors.toList());
    }
    
    public Optional<PlayerDto> getPlayerById(Long id) {
        Optional<Player> player = playerRepository.findById(id);
        return player.map(this::convertToDto);
    }
    
    public List<PlayerDto> getPlayersByTeamId(Long teamId) {
        List<Player> players = playerRepository.findByTeamId(teamId);
        return players.stream().map(this::convertToDto).collect(Collectors.toList());
    }
    
    public PlayerDto createPlayer(CreatePlayerDto createPlayerDto) {
        // Validate team exists
        if (!teamRepository.existsById(createPlayerDto.getTeamId())) {
            throw new IllegalArgumentException("Team with ID " + createPlayerDto.getTeamId() + " does not exist");
        }
        
        // Create player entity
        Player player = new Player();
        player.setFirstName(createPlayerDto.getFirstName());
        player.setLastName(createPlayerDto.getLastName());
        player.setPosition(createPlayerDto.getPosition());
        player.setAge(createPlayerDto.getAge());
        
        // Set team
        Team team = teamRepository.findById(createPlayerDto.getTeamId()).get();
        player.setTeam(team);
        
        // Set statistics (use provided or defaults)
        PlayerStatistics statistics = new PlayerStatistics();
        if (createPlayerDto.getStatistics() != null) {
            statistics.setGoals(createPlayerDto.getStatistics().getGoals() != null ? 
                               createPlayerDto.getStatistics().getGoals() : 0);
            statistics.setAssists(createPlayerDto.getStatistics().getAssists() != null ? 
                                 createPlayerDto.getStatistics().getAssists() : 0);
            statistics.setMatchesPlayed(createPlayerDto.getStatistics().getMatchesPlayed() != null ? 
                                       createPlayerDto.getStatistics().getMatchesPlayed() : 0);
        } else {
            statistics.setGoals(0);
            statistics.setAssists(0);
            statistics.setMatchesPlayed(0);
        }
        player.setStatistics(statistics);
        
        Player savedPlayer = playerRepository.save(player);
        return convertToDto(savedPlayer);
    }
    
    public PlayerDto updatePlayer(Long id, CreatePlayerDto updatePlayerDto) {
        Optional<Player> existingPlayerOpt = playerRepository.findById(id);
        if (existingPlayerOpt.isEmpty()) {
            throw new IllegalArgumentException("Player with ID " + id + " does not exist");
        }
        
        Player existingPlayer = existingPlayerOpt.get();
        
        // Validate team exists
        if (!teamRepository.existsById(updatePlayerDto.getTeamId())) {
            throw new IllegalArgumentException("Team with ID " + updatePlayerDto.getTeamId() + " does not exist");
        }
        
        // Update player properties
        existingPlayer.setFirstName(updatePlayerDto.getFirstName());
        existingPlayer.setLastName(updatePlayerDto.getLastName());
        existingPlayer.setPosition(updatePlayerDto.getPosition());
        existingPlayer.setAge(updatePlayerDto.getAge());
        
        // Update team
        Team team = teamRepository.findById(updatePlayerDto.getTeamId()).get();
        existingPlayer.setTeam(team);
        
        // Update statistics
        if (updatePlayerDto.getStatistics() != null) {
            PlayerStatistics statistics = existingPlayer.getStatistics();
            if (statistics == null) {
                statistics = new PlayerStatistics();
            }
            statistics.setGoals(updatePlayerDto.getStatistics().getGoals() != null ? 
                               updatePlayerDto.getStatistics().getGoals() : statistics.getGoals());
            statistics.setAssists(updatePlayerDto.getStatistics().getAssists() != null ? 
                                 updatePlayerDto.getStatistics().getAssists() : statistics.getAssists());
            statistics.setMatchesPlayed(updatePlayerDto.getStatistics().getMatchesPlayed() != null ? 
                                       updatePlayerDto.getStatistics().getMatchesPlayed() : statistics.getMatchesPlayed());
            existingPlayer.setStatistics(statistics);
        }
        
        Player updatedPlayer = playerRepository.save(existingPlayer);
        return convertToDto(updatedPlayer);
    }
    
    public void deletePlayer(Long id) {
        if (!playerRepository.existsById(id)) {
            throw new IllegalArgumentException("Player with ID " + id + " does not exist");
        }
        playerRepository.deleteById(id);
    }
    
    private PlayerDto convertToDto(Player player) {
        PlayerDto dto = new PlayerDto();
        dto.setId(player.getId());
        dto.setFirstName(player.getFirstName());
        dto.setLastName(player.getLastName());
        dto.setPosition(player.getPosition());
        dto.setAge(player.getAge());
        
        // Get and set team information
        try {
            Long teamId = playerRepository.getTeamIdByPlayerId(player.getId());
            if (teamId != null) {
                Optional<Team> teamOpt = teamRepository.findById(teamId);
                if (teamOpt.isPresent()) {
                    Team team = teamOpt.get();
                    dto.setTeamId(team.getId());
                    dto.setTeamName(team.getName());
                    dto.setTeamCity(team.getCity());
                }
            }
        } catch (Exception e) {
            // Handle case where team might not be found
        }
        
        // Set statistics
        if (player.getStatistics() != null) {
            PlayerStatisticsDto statsDto = new PlayerStatisticsDto();
            statsDto.setGoals(player.getStatistics().getGoals());
            statsDto.setAssists(player.getStatistics().getAssists());
            statsDto.setMatchesPlayed(player.getStatistics().getMatchesPlayed());
            dto.setStatistics(statsDto);
        }
        
        return dto;
    }
}
