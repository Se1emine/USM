package com.football.leaguemanagement.service;

import com.football.leaguemanagement.dto.PlayerDTO;
import com.football.leaguemanagement.entity.Player;
import com.football.leaguemanagement.entity.Team;
import com.football.leaguemanagement.mapper.PlayerMapper;
import com.football.leaguemanagement.repository.PlayerRepository;
import com.football.leaguemanagement.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final PlayerMapper playerMapper;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, 
                        TeamRepository teamRepository,
                        PlayerMapper playerMapper) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
        this.playerMapper = playerMapper;
    }

    public List<PlayerDTO> getAllPlayers() {
        return playerRepository.findAll().stream()
                .map(playerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<PlayerDTO> getPlayerById(Long id) {
        return playerRepository.findById(id)
                .map(playerMapper::toDTO);
    }

    public List<PlayerDTO> getPlayersByTeam(Long teamId) {
        return playerRepository.findByTeamId(teamId).stream()
                .map(playerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<PlayerDTO> getPlayersByPosition(String position) {
        return playerRepository.findByPosition(position).stream()
                .map(playerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<PlayerDTO> getPlayersByNationality(String nationality) {
        return playerRepository.findByNationality(nationality).stream()
                .map(playerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<PlayerDTO> getPlayersByTeamAndPosition(Long teamId, String position) {
        return playerRepository.findByTeamAndPosition(teamId, position).stream()
                .map(playerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<PlayerDTO> getTopScorers(int minGoals) {
        return playerRepository.findTopScorers(minGoals).stream()
                .map(playerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<PlayerDTO> getPlayersByAgeRange(int minAge, int maxAge) {
        return playerRepository.findByAgeRange(minAge, maxAge).stream()
                .map(playerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PlayerDTO createPlayer(PlayerDTO playerDTO) {
        // Validate team exists
        if (playerDTO.getTeamId() != null) {
            Team team = teamRepository.findById(playerDTO.getTeamId())
                    .orElseThrow(() -> new IllegalArgumentException("Team not found with id: " + playerDTO.getTeamId()));

            // Check if jersey number is already taken in the team
            if (playerDTO.getJerseyNumber() != null && 
                playerRepository.existsByTeamIdAndJerseyNumber(playerDTO.getTeamId(), playerDTO.getJerseyNumber())) {
                throw new IllegalArgumentException("Jersey number " + playerDTO.getJerseyNumber() + 
                        " is already taken in team: " + team.getName());
            }
        }

        Player player = playerMapper.toEntity(playerDTO);

        // Set team if provided
        if (playerDTO.getTeamId() != null) {
            Team team = teamRepository.findById(playerDTO.getTeamId()).get(); // Already validated above
            player.setTeam(team);
        }

        Player savedPlayer = playerRepository.save(player);
        return playerMapper.toDTO(savedPlayer);
    }

    public Optional<PlayerDTO> updatePlayer(Long id, PlayerDTO playerDTO) {
        return playerRepository.findById(id)
                .map(existingPlayer -> {
                    // Check jersey number conflict if team or jersey number is being changed
                    if (playerDTO.getTeamId() != null && playerDTO.getJerseyNumber() != null) {
                        boolean teamChanged = existingPlayer.getTeam() == null || 
                                !existingPlayer.getTeam().getId().equals(playerDTO.getTeamId());
                        boolean jerseyChanged = !existingPlayer.getJerseyNumber().equals(playerDTO.getJerseyNumber());
                        
                        if (teamChanged || jerseyChanged) {
                            if (playerRepository.existsByTeamIdAndJerseyNumber(playerDTO.getTeamId(), playerDTO.getJerseyNumber())) {
                                Team team = teamRepository.findById(playerDTO.getTeamId()).orElse(null);
                                String teamName = team != null ? team.getName() : "Unknown";
                                throw new IllegalArgumentException("Jersey number " + playerDTO.getJerseyNumber() + 
                                        " is already taken in team: " + teamName);
                            }
                        }
                    }

                    playerMapper.updateEntityFromDTO(playerDTO, existingPlayer);

                    // Update team if provided
                    if (playerDTO.getTeamId() != null) {
                        Team team = teamRepository.findById(playerDTO.getTeamId())
                                .orElseThrow(() -> new IllegalArgumentException("Team not found with id: " + playerDTO.getTeamId()));
                        existingPlayer.setTeam(team);
                    }

                    Player updatedPlayer = playerRepository.save(existingPlayer);
                    return playerMapper.toDTO(updatedPlayer);
                });
    }

    public boolean deletePlayer(Long id) {
        if (playerRepository.existsById(id)) {
            playerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean existsById(Long id) {
        return playerRepository.existsById(id);
    }

    public long countPlayersByTeam(Long teamId) {
        return playerRepository.countByTeamId(teamId);
    }
}
