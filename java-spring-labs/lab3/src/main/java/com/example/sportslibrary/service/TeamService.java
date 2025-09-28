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
public class TeamService {
    
    @Autowired
    private TeamRepository teamRepository;
    
    @Autowired
    private CoachRepository coachRepository;
    
    @Autowired
    private LeagueRepository leagueRepository;
    
    @Autowired
    private PlayerRepository playerRepository;
    
    @Autowired
    private MatchRepository matchRepository;
    
    public List<TeamDto> getAllTeams() {
        List<Team> teams = teamRepository.findAll();
        return teams.stream().map(this::convertToDto).collect(Collectors.toList());
    }
    
    public Optional<TeamDto> getTeamById(Long id) {
        Optional<Team> team = teamRepository.findById(id);
        return team.map(this::convertToDto);
    }
    
    public TeamDto createTeam(CreateTeamDto createTeamDto) {
        // Validate league exists
        if (!leagueRepository.existsById(createTeamDto.getLeagueId())) {
            throw new IllegalArgumentException("League with ID " + createTeamDto.getLeagueId() + " does not exist");
        }
        
        // Validate coach exists and is available (if provided)
        if (createTeamDto.getCoachId() != null) {
            if (!coachRepository.existsById(createTeamDto.getCoachId())) {
                throw new IllegalArgumentException("Coach with ID " + createTeamDto.getCoachId() + " does not exist");
            }
            
            // Check if coach is already assigned to another team
            Optional<Team> existingTeamWithCoach = teamRepository.findByCoachId(createTeamDto.getCoachId());
            if (existingTeamWithCoach.isPresent()) {
                throw new IllegalArgumentException("Coach with ID " + createTeamDto.getCoachId() + " is already assigned to another team");
            }
        }
        
        // Validate players exist and are available (if provided)
        if (createTeamDto.getPlayerIds() != null && !createTeamDto.getPlayerIds().isEmpty()) {
            for (Long playerId : createTeamDto.getPlayerIds()) {
                if (!playerRepository.existsById(playerId)) {
                    throw new IllegalArgumentException("Player with ID " + playerId + " does not exist");
                }
            }
        }
        
        // Create team entity
        Team team = new Team();
        team.setName(createTeamDto.getName());
        team.setCity(createTeamDto.getCity());
        team.setFoundedYear(createTeamDto.getFoundedYear());
        
        // Set league
        League league = leagueRepository.findById(createTeamDto.getLeagueId()).get();
        team.setLeague(league);
        
        // Set coach (if provided)
        if (createTeamDto.getCoachId() != null) {
            Coach coach = coachRepository.findById(createTeamDto.getCoachId()).get();
            team.setCoach(coach);
        }
        
        // Save team
        Team savedTeam = teamRepository.save(team);
        
        // Update players to belong to this team (if provided)
        if (createTeamDto.getPlayerIds() != null && !createTeamDto.getPlayerIds().isEmpty()) {
            for (Long playerId : createTeamDto.getPlayerIds()) {
                Player player = playerRepository.findById(playerId).get();
                player.setTeam(savedTeam);
                playerRepository.save(player);
            }
        }
        
        return convertToDto(savedTeam);
    }
    
    public TeamDto updateTeam(Long id, CreateTeamDto updateTeamDto) {
        Optional<Team> existingTeamOpt = teamRepository.findById(id);
        if (existingTeamOpt.isEmpty()) {
            throw new IllegalArgumentException("Team with ID " + id + " does not exist");
        }
        
        Team existingTeam = existingTeamOpt.get();
        
        // Validate league exists
        if (!leagueRepository.existsById(updateTeamDto.getLeagueId())) {
            throw new IllegalArgumentException("League with ID " + updateTeamDto.getLeagueId() + " does not exist");
        }
        
        // Validate coach exists and is available (if provided)
        if (updateTeamDto.getCoachId() != null) {
            if (!coachRepository.existsById(updateTeamDto.getCoachId())) {
                throw new IllegalArgumentException("Coach with ID " + updateTeamDto.getCoachId() + " does not exist");
            }
            
            // Check if coach is already assigned to another team (excluding current team)
            Optional<Team> existingTeamWithCoach = teamRepository.findByCoachId(updateTeamDto.getCoachId());
            if (existingTeamWithCoach.isPresent() && !existingTeamWithCoach.get().getId().equals(id)) {
                throw new IllegalArgumentException("Coach with ID " + updateTeamDto.getCoachId() + " is already assigned to another team");
            }
        }
        
        // Update team properties
        existingTeam.setName(updateTeamDto.getName());
        existingTeam.setCity(updateTeamDto.getCity());
        existingTeam.setFoundedYear(updateTeamDto.getFoundedYear());
        
        // Update league
        League league = leagueRepository.findById(updateTeamDto.getLeagueId()).get();
        existingTeam.setLeague(league);
        
        // Update coach
        if (updateTeamDto.getCoachId() != null) {
            Coach coach = coachRepository.findById(updateTeamDto.getCoachId()).get();
            existingTeam.setCoach(coach);
        } else {
            existingTeam.setCoach(null);
        }
        
        Team updatedTeam = teamRepository.save(existingTeam);
        return convertToDto(updatedTeam);
    }
    
    public void deleteTeam(Long id) {
        if (!teamRepository.existsById(id)) {
            throw new IllegalArgumentException("Team with ID " + id + " does not exist");
        }
        teamRepository.deleteById(id);
    }
    
    private TeamDto convertToDto(Team team) {
        TeamDto dto = new TeamDto();
        dto.setId(team.getId());
        dto.setName(team.getName());
        dto.setCity(team.getCity());
        dto.setFoundedYear(team.getFoundedYear());
        
        // Get and set coach information
        try {
            Long coachId = teamRepository.getCoachIdByTeamId(team.getId());
            if (coachId != null) {
                Optional<Coach> coachOpt = coachRepository.findById(coachId);
                if (coachOpt.isPresent()) {
                    Coach coach = coachOpt.get();
                    CoachDto coachDto = new CoachDto();
                    coachDto.setId(coach.getId());
                    coachDto.setFirstName(coach.getFirstName());
                    coachDto.setLastName(coach.getLastName());
                    coachDto.setExperienceYears(coach.getExperienceYears());
                    coachDto.setNationality(coach.getNationality());
                    dto.setCoach(coachDto);
                }
            }
        } catch (Exception e) {
            // Coach is optional, continue without it
        }
        
        // Get and set league information
        try {
            Long leagueId = teamRepository.getLeagueIdByTeamId(team.getId());
            if (leagueId != null) {
                Optional<League> leagueOpt = leagueRepository.findById(leagueId);
                if (leagueOpt.isPresent()) {
                    League league = leagueOpt.get();
                    dto.setLeagueId(league.getId());
                    dto.setLeagueName(league.getName());
                    dto.setLeagueCountry(league.getCountry());
                    dto.setLeagueSeason(league.getSeason());
                }
            }
        } catch (Exception e) {
            // Handle case where league might not be found
        }
        
        // Set players information
        List<Player> players = playerRepository.findByTeamId(team.getId());
        List<PlayerDto> playerDtos = players.stream().map(this::convertPlayerToDto).collect(Collectors.toList());
        dto.setPlayers(playerDtos);
        
        // Set matches information
        List<Match> matches = matchRepository.findByTeamId(team.getId());
        List<MatchDto> matchDtos = matches.stream().map(this::convertMatchToDto).collect(Collectors.toList());
        dto.setMatches(matchDtos);
        
        return dto;
    }
    
    private PlayerDto convertPlayerToDto(Player player) {
        PlayerDto dto = new PlayerDto();
        dto.setId(player.getId());
        dto.setFirstName(player.getFirstName());
        dto.setLastName(player.getLastName());
        dto.setPosition(player.getPosition());
        dto.setAge(player.getAge());
        
        // Set statistics
        PlayerStatisticsDto statsDto = new PlayerStatisticsDto();
        statsDto.setGoals(player.getStatistics().getGoals());
        statsDto.setAssists(player.getStatistics().getAssists());
        statsDto.setMatchesPlayed(player.getStatistics().getMatchesPlayed());
        dto.setStatistics(statsDto);
        
        return dto;
    }
    
    private MatchDto convertMatchToDto(Match match) {
        MatchDto dto = new MatchDto();
        dto.setId(match.getId());
        dto.setMatchDate(match.getMatchDate());
        dto.setHomeTeamScore(match.getHomeTeamScore());
        dto.setAwayTeamScore(match.getAwayTeamScore());
        dto.setStatus(match.getStatus());
        
        // Get and set home team info
        try {
            Long homeTeamId = matchRepository.getHomeTeamIdByMatchId(match.getId());
            if (homeTeamId != null) {
                Optional<Team> homeTeamOpt = teamRepository.findById(homeTeamId);
                if (homeTeamOpt.isPresent()) {
                    Team homeTeam = homeTeamOpt.get();
                    dto.setHomeTeamId(homeTeam.getId());
                    dto.setHomeTeamName(homeTeam.getName());
                    dto.setHomeTeamCity(homeTeam.getCity());
                }
            }
        } catch (Exception e) {
            // Handle case where home team might not be found
        }
        
        // Get and set away team info
        try {
            Long awayTeamId = matchRepository.getAwayTeamIdByMatchId(match.getId());
            if (awayTeamId != null) {
                Optional<Team> awayTeamOpt = teamRepository.findById(awayTeamId);
                if (awayTeamOpt.isPresent()) {
                    Team awayTeam = awayTeamOpt.get();
                    dto.setAwayTeamId(awayTeam.getId());
                    dto.setAwayTeamName(awayTeam.getName());
                    dto.setAwayTeamCity(awayTeam.getCity());
                }
            }
        } catch (Exception e) {
            // Handle case where away team might not be found
        }
        
        // Get and set league info
        try {
            Long leagueId = matchRepository.getLeagueIdByMatchId(match.getId());
            if (leagueId != null) {
                Optional<League> leagueOpt = leagueRepository.findById(leagueId);
                if (leagueOpt.isPresent()) {
                    League league = leagueOpt.get();
                    dto.setLeagueId(league.getId());
                    dto.setLeagueName(league.getName());
                    dto.setLeagueCountry(league.getCountry());
                }
            }
        } catch (Exception e) {
            // Handle case where league might not be found
        }
        
        return dto;
    }
}
