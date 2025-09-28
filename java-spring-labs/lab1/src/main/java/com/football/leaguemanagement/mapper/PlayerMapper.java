package com.football.leaguemanagement.mapper;

import com.football.leaguemanagement.dto.PlayerDTO;
import com.football.leaguemanagement.dto.PlayerStatisticsDTO;
import com.football.leaguemanagement.entity.Player;
import com.football.leaguemanagement.entity.PlayerStatistics;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {

    public PlayerDTO toDTO(Player player) {
        if (player == null) {
            return null;
        }

        PlayerDTO dto = new PlayerDTO();
        dto.setId(player.getId());
        dto.setName(player.getName());
        dto.setAge(player.getAge());
        dto.setPosition(player.getPosition());
        dto.setJerseyNumber(player.getJerseyNumber());
        dto.setNationality(player.getNationality());

        if (player.getTeam() != null) {
            dto.setTeamId(player.getTeam().getId());
        }

        if (player.getStatistics() != null) {
            dto.setStatistics(toStatisticsDTO(player.getStatistics()));
        }

        return dto;
    }

    public Player toEntity(PlayerDTO dto) {
        if (dto == null) {
            return null;
        }

        Player player = new Player();
        player.setId(dto.getId());
        player.setName(dto.getName());
        player.setAge(dto.getAge());
        player.setPosition(dto.getPosition());
        player.setJerseyNumber(dto.getJerseyNumber());
        player.setNationality(dto.getNationality());

        if (dto.getStatistics() != null) {
            player.setStatistics(toStatisticsEntity(dto.getStatistics()));
        } else {
            player.setStatistics(new PlayerStatistics());
        }

        return player;
    }

    public void updateEntityFromDTO(PlayerDTO dto, Player player) {
        if (dto == null || player == null) {
            return;
        }

        player.setName(dto.getName());
        player.setAge(dto.getAge());
        player.setPosition(dto.getPosition());
        player.setJerseyNumber(dto.getJerseyNumber());
        player.setNationality(dto.getNationality());

        if (dto.getStatistics() != null) {
            if (player.getStatistics() == null) {
                player.setStatistics(new PlayerStatistics());
            }
            updateStatisticsFromDTO(dto.getStatistics(), player.getStatistics());
        }
    }

    private PlayerStatisticsDTO toStatisticsDTO(PlayerStatistics statistics) {
        if (statistics == null) {
            return null;
        }

        return new PlayerStatisticsDTO(
                statistics.getGoals(),
                statistics.getAssists(),
                statistics.getYellowCards(),
                statistics.getRedCards(),
                statistics.getMatchesPlayed()
        );
    }

    private PlayerStatistics toStatisticsEntity(PlayerStatisticsDTO dto) {
        if (dto == null) {
            return null;
        }

        return new PlayerStatistics(
                dto.getGoals(),
                dto.getAssists(),
                dto.getYellowCards(),
                dto.getRedCards(),
                dto.getMatchesPlayed()
        );
    }

    private void updateStatisticsFromDTO(PlayerStatisticsDTO dto, PlayerStatistics statistics) {
        statistics.setGoals(dto.getGoals());
        statistics.setAssists(dto.getAssists());
        statistics.setYellowCards(dto.getYellowCards());
        statistics.setRedCards(dto.getRedCards());
        statistics.setMatchesPlayed(dto.getMatchesPlayed());
    }
}
