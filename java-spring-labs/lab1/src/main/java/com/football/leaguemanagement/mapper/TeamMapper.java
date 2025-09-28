package com.football.leaguemanagement.mapper;

import com.football.leaguemanagement.dto.TeamDTO;
import com.football.leaguemanagement.entity.Team;
import com.football.leaguemanagement.entity.Player;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TeamMapper {

    public TeamDTO toDTO(Team team) {
        if (team == null) {
            return null;
        }

        TeamDTO dto = new TeamDTO();
        dto.setId(team.getId());
        dto.setName(team.getName());
        dto.setCity(team.getCity());
        dto.setFoundedYear(team.getFoundedYear());
        dto.setStadium(team.getStadium());

        if (team.getLeague() != null) {
            dto.setLeagueId(team.getLeague().getId());
        }

        if (team.getCoach() != null) {
            dto.setCoachId(team.getCoach().getId());
        }

        if (team.getPlayers() != null) {
            dto.setPlayerIds(team.getPlayers().stream()
                    .map(Player::getId)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    public Team toEntity(TeamDTO dto) {
        if (dto == null) {
            return null;
        }

        Team team = new Team();
        team.setId(dto.getId());
        team.setName(dto.getName());
        team.setCity(dto.getCity());
        team.setFoundedYear(dto.getFoundedYear());
        team.setStadium(dto.getStadium());

        return team;
    }

    public void updateEntityFromDTO(TeamDTO dto, Team team) {
        if (dto == null || team == null) {
            return;
        }

        team.setName(dto.getName());
        team.setCity(dto.getCity());
        team.setFoundedYear(dto.getFoundedYear());
        team.setStadium(dto.getStadium());
    }
}
