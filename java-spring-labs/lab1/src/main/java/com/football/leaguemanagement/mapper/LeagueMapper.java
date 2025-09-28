package com.football.leaguemanagement.mapper;

import com.football.leaguemanagement.dto.LeagueDTO;
import com.football.leaguemanagement.entity.League;
import com.football.leaguemanagement.entity.Team;
import com.football.leaguemanagement.entity.Match;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class LeagueMapper {

    public LeagueDTO toDTO(League league) {
        if (league == null) {
            return null;
        }

        LeagueDTO dto = new LeagueDTO();
        dto.setId(league.getId());
        dto.setName(league.getName());
        dto.setCountry(league.getCountry());
        dto.setSeason(league.getSeason());

        if (league.getTeams() != null) {
            dto.setTeamIds(league.getTeams().stream()
                    .map(Team::getId)
                    .collect(Collectors.toList()));
        }

        if (league.getMatches() != null) {
            dto.setMatchIds(league.getMatches().stream()
                    .map(Match::getId)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    public League toEntity(LeagueDTO dto) {
        if (dto == null) {
            return null;
        }

        League league = new League();
        league.setId(dto.getId());
        league.setName(dto.getName());
        league.setCountry(dto.getCountry());
        league.setSeason(dto.getSeason());

        return league;
    }

    public void updateEntityFromDTO(LeagueDTO dto, League league) {
        if (dto == null || league == null) {
            return;
        }

        league.setName(dto.getName());
        league.setCountry(dto.getCountry());
        league.setSeason(dto.getSeason());
    }
}
