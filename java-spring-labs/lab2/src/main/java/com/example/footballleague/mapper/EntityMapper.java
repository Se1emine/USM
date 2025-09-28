package com.example.footballleague.mapper;

import com.example.footballleague.dto.*;
import com.example.footballleague.entity.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityMapper {

    // League mappings
    public LeagueDTO toLeagueDTO(League league) {
        if (league == null) return null;
        
        LeagueDTO dto = new LeagueDTO();
        dto.setId(league.getId());
        dto.setName(league.getName());
        dto.setDescription(league.getDescription());
        dto.setCountry(league.getCountry());
        
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

    public League toLeague(LeagueDTO dto) {
        if (dto == null) return null;
        
        League league = new League();
        league.setId(dto.getId());
        league.setName(dto.getName());
        league.setDescription(dto.getDescription());
        league.setCountry(dto.getCountry());
        
        return league;
    }

    // Coach mappings
    public CoachDTO toCoachDTO(Coach coach) {
        if (coach == null) return null;
        
        CoachDTO dto = new CoachDTO();
        dto.setId(coach.getId());
        dto.setFirstName(coach.getFirstName());
        dto.setLastName(coach.getLastName());
        dto.setBirthDate(coach.getBirthDate());
        dto.setNationality(coach.getNationality());
        dto.setExperienceYears(coach.getExperienceYears());
        
        if (coach.getTeam() != null) {
            dto.setTeamId(coach.getTeam().getId());
        }
        
        return dto;
    }

    public Coach toCoach(CoachDTO dto) {
        if (dto == null) return null;
        
        Coach coach = new Coach();
        coach.setId(dto.getId());
        coach.setFirstName(dto.getFirstName());
        coach.setLastName(dto.getLastName());
        coach.setBirthDate(dto.getBirthDate());
        coach.setNationality(dto.getNationality());
        coach.setExperienceYears(dto.getExperienceYears());
        
        return coach;
    }

    // Team mappings
    public TeamDTO toTeamDTO(Team team) {
        if (team == null) return null;
        
        TeamDTO dto = new TeamDTO();
        dto.setId(team.getId());
        dto.setName(team.getName());
        dto.setCity(team.getCity());
        dto.setFoundedDate(team.getFoundedDate());
        dto.setStadium(team.getStadium());
        
        if (team.getCoach() != null) {
            dto.setCoachId(team.getCoach().getId());
        }
        
        if (team.getLeague() != null) {
            dto.setLeagueId(team.getLeague().getId());
        }
        
        if (team.getPlayers() != null) {
            dto.setPlayerIds(team.getPlayers().stream()
                    .map(Player::getId)
                    .collect(Collectors.toList()));
        }
        
        return dto;
    }

    public Team toTeam(TeamDTO dto) {
        if (dto == null) return null;
        
        Team team = new Team();
        team.setId(dto.getId());
        team.setName(dto.getName());
        team.setCity(dto.getCity());
        team.setFoundedDate(dto.getFoundedDate());
        team.setStadium(dto.getStadium());
        
        return team;
    }

    // Player mappings
    public PlayerDTO toPlayerDTO(Player player) {
        if (player == null) return null;
        
        PlayerDTO dto = new PlayerDTO();
        dto.setId(player.getId());
        dto.setFirstName(player.getFirstName());
        dto.setLastName(player.getLastName());
        dto.setBirthDate(player.getBirthDate());
        dto.setNationality(player.getNationality());
        dto.setPosition(player.getPosition());
        dto.setJerseyNumber(player.getJerseyNumber());
        
        if (player.getStatistics() != null) {
            dto.setStatistics(toPlayerStatisticsDTO(player.getStatistics()));
        }
        
        if (player.getTeam() != null) {
            dto.setTeamId(player.getTeam().getId());
        }
        
        return dto;
    }

    public Player toPlayer(PlayerDTO dto) {
        if (dto == null) return null;
        
        Player player = new Player();
        player.setId(dto.getId());
        player.setFirstName(dto.getFirstName());
        player.setLastName(dto.getLastName());
        player.setBirthDate(dto.getBirthDate());
        player.setNationality(dto.getNationality());
        player.setPosition(dto.getPosition());
        player.setJerseyNumber(dto.getJerseyNumber());
        
        if (dto.getStatistics() != null) {
            player.setStatistics(toPlayerStatistics(dto.getStatistics()));
        }
        
        return player;
    }

    // PlayerStatistics mappings
    public PlayerStatisticsDTO toPlayerStatisticsDTO(PlayerStatistics statistics) {
        if (statistics == null) return null;
        
        return new PlayerStatisticsDTO(
                statistics.getGoals(),
                statistics.getAssists(),
                statistics.getMatchesPlayed(),
                statistics.getYellowCards(),
                statistics.getRedCards()
        );
    }

    public PlayerStatistics toPlayerStatistics(PlayerStatisticsDTO dto) {
        if (dto == null) return null;
        
        return new PlayerStatistics(
                dto.getGoals(),
                dto.getAssists(),
                dto.getMatchesPlayed(),
                dto.getYellowCards(),
                dto.getRedCards()
        );
    }

    // Match mappings
    public MatchDTO toMatchDTO(Match match) {
        if (match == null) return null;
        
        MatchDTO dto = new MatchDTO();
        dto.setId(match.getId());
        dto.setMatchDate(match.getMatchDate());
        dto.setHomeTeamScore(match.getHomeTeamScore());
        dto.setAwayTeamScore(match.getAwayTeamScore());
        dto.setStatus(match.getStatus());
        dto.setVenue(match.getVenue());
        
        if (match.getHomeTeam() != null) {
            dto.setHomeTeamId(match.getHomeTeam().getId());
        }
        
        if (match.getAwayTeam() != null) {
            dto.setAwayTeamId(match.getAwayTeam().getId());
        }
        
        if (match.getLeague() != null) {
            dto.setLeagueId(match.getLeague().getId());
        }
        
        return dto;
    }

    public Match toMatch(MatchDTO dto) {
        if (dto == null) return null;
        
        Match match = new Match();
        match.setId(dto.getId());
        match.setMatchDate(dto.getMatchDate());
        match.setHomeTeamScore(dto.getHomeTeamScore());
        match.setAwayTeamScore(dto.getAwayTeamScore());
        match.setStatus(dto.getStatus());
        match.setVenue(dto.getVenue());
        
        return match;
    }

    // List mappings
    public List<LeagueDTO> toLeagueDTOList(List<League> leagues) {
        return leagues.stream().map(this::toLeagueDTO).collect(Collectors.toList());
    }

    public List<TeamDTO> toTeamDTOList(List<Team> teams) {
        return teams.stream().map(this::toTeamDTO).collect(Collectors.toList());
    }

    public List<PlayerDTO> toPlayerDTOList(List<Player> players) {
        return players.stream().map(this::toPlayerDTO).collect(Collectors.toList());
    }

    public List<CoachDTO> toCoachDTOList(List<Coach> coaches) {
        return coaches.stream().map(this::toCoachDTO).collect(Collectors.toList());
    }

    public List<MatchDTO> toMatchDTOList(List<Match> matches) {
        return matches.stream().map(this::toMatchDTO).collect(Collectors.toList());
    }
}
