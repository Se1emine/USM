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
public class MatchService {
    
    @Autowired
    private MatchRepository matchRepository;
    
    @Autowired
    private TeamRepository teamRepository;
    
    @Autowired
    private LeagueRepository leagueRepository;
    
    public List<MatchDto> getAllMatches() {
        List<Match> matches = matchRepository.findAll();
        return matches.stream().map(this::convertToDto).collect(Collectors.toList());
    }
    
    public Optional<MatchDto> getMatchById(Long id) {
        Optional<Match> match = matchRepository.findById(id);
        return match.map(this::convertToDto);
    }
    
    public List<MatchDto> getMatchesByLeagueId(Long leagueId) {
        List<Match> matches = matchRepository.findByLeagueId(leagueId);
        return matches.stream().map(this::convertToDto).collect(Collectors.toList());
    }
    
    public List<MatchDto> getMatchesByTeamId(Long teamId) {
        List<Match> matches = matchRepository.findByTeamId(teamId);
        return matches.stream().map(this::convertToDto).collect(Collectors.toList());
    }
    
    public MatchDto createMatch(CreateMatchDto createMatchDto) {
        // Validate teams exist
        if (!teamRepository.existsById(createMatchDto.getHomeTeamId())) {
            throw new IllegalArgumentException("Home team with ID " + createMatchDto.getHomeTeamId() + " does not exist");
        }
        
        if (!teamRepository.existsById(createMatchDto.getAwayTeamId())) {
            throw new IllegalArgumentException("Away team with ID " + createMatchDto.getAwayTeamId() + " does not exist");
        }
        
        // Validate league exists
        if (!leagueRepository.existsById(createMatchDto.getLeagueId())) {
            throw new IllegalArgumentException("League with ID " + createMatchDto.getLeagueId() + " does not exist");
        }
        
        // Validate that home team and away team are different
        if (createMatchDto.getHomeTeamId().equals(createMatchDto.getAwayTeamId())) {
            throw new IllegalArgumentException("Home team and away team cannot be the same");
        }
        
        // Validate that both teams belong to the same league
        Team homeTeam = teamRepository.findById(createMatchDto.getHomeTeamId()).get();
        Team awayTeam = teamRepository.findById(createMatchDto.getAwayTeamId()).get();
        
        if (!homeTeam.getLeague().getId().equals(createMatchDto.getLeagueId()) ||
            !awayTeam.getLeague().getId().equals(createMatchDto.getLeagueId())) {
            throw new IllegalArgumentException("Both teams must belong to the specified league");
        }
        
        // Create match entity
        Match match = new Match();
        match.setMatchDate(createMatchDto.getMatchDate());
        match.setHomeTeamScore(createMatchDto.getHomeTeamScore());
        match.setAwayTeamScore(createMatchDto.getAwayTeamScore());
        match.setStatus(createMatchDto.getStatus());
        
        // Set teams and league
        match.setHomeTeam(homeTeam);
        match.setAwayTeam(awayTeam);
        League league = leagueRepository.findById(createMatchDto.getLeagueId()).get();
        match.setLeague(league);
        
        Match savedMatch = matchRepository.save(match);
        return convertToDto(savedMatch);
    }
    
    public MatchDto updateMatch(Long id, CreateMatchDto updateMatchDto) {
        Optional<Match> existingMatchOpt = matchRepository.findById(id);
        if (existingMatchOpt.isEmpty()) {
            throw new IllegalArgumentException("Match with ID " + id + " does not exist");
        }
        
        Match existingMatch = existingMatchOpt.get();
        
        // Validate teams exist
        if (!teamRepository.existsById(updateMatchDto.getHomeTeamId())) {
            throw new IllegalArgumentException("Home team with ID " + updateMatchDto.getHomeTeamId() + " does not exist");
        }
        
        if (!teamRepository.existsById(updateMatchDto.getAwayTeamId())) {
            throw new IllegalArgumentException("Away team with ID " + updateMatchDto.getAwayTeamId() + " does not exist");
        }
        
        // Validate league exists
        if (!leagueRepository.existsById(updateMatchDto.getLeagueId())) {
            throw new IllegalArgumentException("League with ID " + updateMatchDto.getLeagueId() + " does not exist");
        }
        
        // Validate that home team and away team are different
        if (updateMatchDto.getHomeTeamId().equals(updateMatchDto.getAwayTeamId())) {
            throw new IllegalArgumentException("Home team and away team cannot be the same");
        }
        
        // Validate that both teams belong to the same league
        Team homeTeam = teamRepository.findById(updateMatchDto.getHomeTeamId()).get();
        Team awayTeam = teamRepository.findById(updateMatchDto.getAwayTeamId()).get();
        
        if (!homeTeam.getLeague().getId().equals(updateMatchDto.getLeagueId()) ||
            !awayTeam.getLeague().getId().equals(updateMatchDto.getLeagueId())) {
            throw new IllegalArgumentException("Both teams must belong to the specified league");
        }
        
        // Update match properties
        existingMatch.setMatchDate(updateMatchDto.getMatchDate());
        existingMatch.setHomeTeamScore(updateMatchDto.getHomeTeamScore());
        existingMatch.setAwayTeamScore(updateMatchDto.getAwayTeamScore());
        existingMatch.setStatus(updateMatchDto.getStatus());
        
        // Update teams and league
        existingMatch.setHomeTeam(homeTeam);
        existingMatch.setAwayTeam(awayTeam);
        League league = leagueRepository.findById(updateMatchDto.getLeagueId()).get();
        existingMatch.setLeague(league);
        
        Match updatedMatch = matchRepository.save(existingMatch);
        return convertToDto(updatedMatch);
    }
    
    public void deleteMatch(Long id) {
        if (!matchRepository.existsById(id)) {
            throw new IllegalArgumentException("Match with ID " + id + " does not exist");
        }
        matchRepository.deleteById(id);
    }
    
    private MatchDto convertToDto(Match match) {
        MatchDto dto = new MatchDto();
        dto.setId(match.getId());
        dto.setMatchDate(match.getMatchDate());
        dto.setHomeTeamScore(match.getHomeTeamScore());
        dto.setAwayTeamScore(match.getAwayTeamScore());
        dto.setStatus(match.getStatus());
        
        // Get and set home team information
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
        
        // Get and set away team information
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
        
        // Get and set league information
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
