package com.football.leaguemanagement.mapper;

import com.football.leaguemanagement.dto.MatchDTO;
import com.football.leaguemanagement.entity.Match;
import org.springframework.stereotype.Component;

@Component
public class MatchMapper {

    public MatchDTO toDTO(Match match) {
        if (match == null) {
            return null;
        }

        MatchDTO dto = new MatchDTO();
        dto.setId(match.getId());
        dto.setMatchDate(match.getMatchDate());
        dto.setHomeTeamScore(match.getHomeTeamScore());
        dto.setAwayTeamScore(match.getAwayTeamScore());
        dto.setStatus(match.getStatus());
        dto.setRound(match.getRound());

        if (match.getLeague() != null) {
            dto.setLeagueId(match.getLeague().getId());
            dto.setLeagueName(match.getLeague().getName());
        }

        if (match.getHomeTeam() != null) {
            dto.setHomeTeamId(match.getHomeTeam().getId());
            dto.setHomeTeamName(match.getHomeTeam().getName());
        }

        if (match.getAwayTeam() != null) {
            dto.setAwayTeamId(match.getAwayTeam().getId());
            dto.setAwayTeamName(match.getAwayTeam().getName());
        }

        return dto;
    }

    public Match toEntity(MatchDTO dto) {
        if (dto == null) {
            return null;
        }

        Match match = new Match();
        match.setId(dto.getId());
        match.setMatchDate(dto.getMatchDate());
        match.setHomeTeamScore(dto.getHomeTeamScore());
        match.setAwayTeamScore(dto.getAwayTeamScore());
        match.setStatus(dto.getStatus());
        match.setRound(dto.getRound());

        return match;
    }

    public void updateEntityFromDTO(MatchDTO dto, Match match) {
        if (dto == null || match == null) {
            return;
        }

        match.setMatchDate(dto.getMatchDate());
        match.setHomeTeamScore(dto.getHomeTeamScore());
        match.setAwayTeamScore(dto.getAwayTeamScore());
        match.setStatus(dto.getStatus());
        match.setRound(dto.getRound());
    }
}
