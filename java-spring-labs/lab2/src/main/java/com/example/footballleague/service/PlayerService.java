package com.example.footballleague.service;

import com.example.footballleague.dao.PlayerDAO;
import com.example.footballleague.dao.TeamDAO;
import com.example.footballleague.dto.PlayerDTO;
import com.example.footballleague.entity.Player;
import com.example.footballleague.entity.Team;
import com.example.footballleague.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlayerService {

    @Autowired
    private PlayerDAO playerDAO;

    @Autowired
    private TeamDAO teamDAO;

    @Autowired
    private EntityMapper entityMapper;

    public PlayerDTO createPlayer(PlayerDTO playerDTO) {
        Player player = entityMapper.toPlayer(playerDTO);
        
        // Set team if provided
        if (playerDTO.getTeamId() != null) {
            Team team = teamDAO.findById(playerDTO.getTeamId());
            if (team != null) {
                player.setTeam(team);
            }
        }
        
        // Check if jersey number is unique within the team
        if (player.getTeam() != null && player.getJerseyNumber() > 0) {
            Player existingPlayer = playerDAO.findByJerseyNumberAndTeam(
                    player.getJerseyNumber(), player.getTeam().getId());
            if (existingPlayer != null) {
                throw new RuntimeException("Jersey number " + player.getJerseyNumber() + 
                        " is already taken by another player in this team");
            }
        }
        
        Player savedPlayer = playerDAO.save(player);
        return entityMapper.toPlayerDTO(savedPlayer);
    }

    public PlayerDTO updatePlayer(Long id, PlayerDTO playerDTO) {
        Player existingPlayer = playerDAO.findById(id);
        if (existingPlayer == null) {
            throw new RuntimeException("Player not found with id: " + id);
        }
        
        existingPlayer.setFirstName(playerDTO.getFirstName());
        existingPlayer.setLastName(playerDTO.getLastName());
        existingPlayer.setBirthDate(playerDTO.getBirthDate());
        existingPlayer.setNationality(playerDTO.getNationality());
        existingPlayer.setPosition(playerDTO.getPosition());
        existingPlayer.setJerseyNumber(playerDTO.getJerseyNumber());
        
        if (playerDTO.getStatistics() != null) {
            existingPlayer.setStatistics(entityMapper.toPlayerStatistics(playerDTO.getStatistics()));
        }
        
        // Update team if provided
        if (playerDTO.getTeamId() != null) {
            Team team = teamDAO.findById(playerDTO.getTeamId());
            if (team != null) {
                // Check jersey number uniqueness in new team
                if (existingPlayer.getJerseyNumber() > 0) {
                    Player playerWithSameNumber = playerDAO.findByJerseyNumberAndTeam(
                            existingPlayer.getJerseyNumber(), team.getId());
                    if (playerWithSameNumber != null && !playerWithSameNumber.getId().equals(id)) {
                        throw new RuntimeException("Jersey number " + existingPlayer.getJerseyNumber() + 
                                " is already taken by another player in this team");
                    }
                }
                existingPlayer.setTeam(team);
            }
        }
        
        Player updatedPlayer = playerDAO.update(existingPlayer);
        return entityMapper.toPlayerDTO(updatedPlayer);
    }

    public PlayerDTO getPlayerById(Long id) {
        Player player = playerDAO.findById(id);
        if (player == null) {
            throw new RuntimeException("Player not found with id: " + id);
        }
        return entityMapper.toPlayerDTO(player);
    }

    public List<PlayerDTO> getAllPlayers() {
        List<Player> players = playerDAO.findAll();
        return entityMapper.toPlayerDTOList(players);
    }

    public void deletePlayer(Long id) {
        Player player = playerDAO.findById(id);
        if (player == null) {
            throw new RuntimeException("Player not found with id: " + id);
        }
        playerDAO.delete(player);
    }

    public List<PlayerDTO> getPlayersByTeam(Long teamId) {
        List<Player> players = playerDAO.findByTeamId(teamId);
        return entityMapper.toPlayerDTOList(players);
    }

    public List<PlayerDTO> getPlayersByPosition(Player.Position position) {
        List<Player> players = playerDAO.findByPosition(position);
        return entityMapper.toPlayerDTOList(players);
    }

    public List<PlayerDTO> getPlayersByNationality(String nationality) {
        List<Player> players = playerDAO.findByNationality(nationality);
        return entityMapper.toPlayerDTOList(players);
    }

    public List<PlayerDTO> getTopScorers(int limit) {
        List<Player> players = playerDAO.findTopScorers(limit);
        return entityMapper.toPlayerDTOList(players);
    }

    public List<PlayerDTO> getPlayersByFullName(String firstName, String lastName) {
        List<Player> players = playerDAO.findByFullName(firstName, lastName);
        return entityMapper.toPlayerDTOList(players);
    }

    public PlayerDTO getPlayerByJerseyNumberAndTeam(int jerseyNumber, Long teamId) {
        Player player = playerDAO.findByJerseyNumberAndTeam(jerseyNumber, teamId);
        if (player == null) {
            throw new RuntimeException("Player not found with jersey number " + jerseyNumber + 
                    " in team with id: " + teamId);
        }
        return entityMapper.toPlayerDTO(player);
    }
}
