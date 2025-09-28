package com.example.footballleague.service;

import com.example.footballleague.dao.LeagueDAO;
import com.example.footballleague.dao.MatchDAO;
import com.example.footballleague.dao.TeamDAO;
import com.example.footballleague.dto.MatchDTO;
import com.example.footballleague.entity.League;
import com.example.footballleague.entity.Match;
import com.example.footballleague.entity.Team;
import com.example.footballleague.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class MatchService {

    @Autowired
    private MatchDAO matchDAO;

    @Autowired
    private TeamDAO teamDAO;

    @Autowired
    private LeagueDAO leagueDAO;

    @Autowired
    private EntityMapper entityMapper;

    public MatchDTO createMatch(MatchDTO matchDTO) {
        Match match = entityMapper.toMatch(matchDTO);
        
        // Set home team
        if (matchDTO.getHomeTeamId() != null) {
            Team homeTeam = teamDAO.findById(matchDTO.getHomeTeamId());
            if (homeTeam == null) {
                throw new RuntimeException("Home team not found with id: " + matchDTO.getHomeTeamId());
            }
            match.setHomeTeam(homeTeam);
        }
        
        // Set away team
        if (matchDTO.getAwayTeamId() != null) {
            Team awayTeam = teamDAO.findById(matchDTO.getAwayTeamId());
            if (awayTeam == null) {
                throw new RuntimeException("Away team not found with id: " + matchDTO.getAwayTeamId());
            }
            match.setAwayTeam(awayTeam);
        }
        
        // Validate that home and away teams are different
        if (match.getHomeTeam() != null && match.getAwayTeam() != null && 
            match.getHomeTeam().getId().equals(match.getAwayTeam().getId())) {
            throw new RuntimeException("Home team and away team cannot be the same");
        }
        
        // Set league if provided
        if (matchDTO.getLeagueId() != null) {
            League league = leagueDAO.findById(matchDTO.getLeagueId());
            if (league != null) {
                match.setLeague(league);
            }
        }
        
        // Set default status if not provided
        if (match.getStatus() == null) {
            match.setStatus(Match.MatchStatus.SCHEDULED);
        }
        
        Match savedMatch = matchDAO.save(match);
        return entityMapper.toMatchDTO(savedMatch);
    }

    public MatchDTO updateMatch(Long id, MatchDTO matchDTO) {
        Match existingMatch = matchDAO.findById(id);
        if (existingMatch == null) {
            throw new RuntimeException("Match not found with id: " + id);
        }
        
        existingMatch.setMatchDate(matchDTO.getMatchDate());
        existingMatch.setHomeTeamScore(matchDTO.getHomeTeamScore());
        existingMatch.setAwayTeamScore(matchDTO.getAwayTeamScore());
        existingMatch.setStatus(matchDTO.getStatus());
        existingMatch.setVenue(matchDTO.getVenue());
        
        // Update home team if provided
        if (matchDTO.getHomeTeamId() != null) {
            Team homeTeam = teamDAO.findById(matchDTO.getHomeTeamId());
            if (homeTeam == null) {
                throw new RuntimeException("Home team not found with id: " + matchDTO.getHomeTeamId());
            }
            existingMatch.setHomeTeam(homeTeam);
        }
        
        // Update away team if provided
        if (matchDTO.getAwayTeamId() != null) {
            Team awayTeam = teamDAO.findById(matchDTO.getAwayTeamId());
            if (awayTeam == null) {
                throw new RuntimeException("Away team not found with id: " + matchDTO.getAwayTeamId());
            }
            existingMatch.setAwayTeam(awayTeam);
        }
        
        // Validate that home and away teams are different
        if (existingMatch.getHomeTeam() != null && existingMatch.getAwayTeam() != null && 
            existingMatch.getHomeTeam().getId().equals(existingMatch.getAwayTeam().getId())) {
            throw new RuntimeException("Home team and away team cannot be the same");
        }
        
        // Update league if provided
        if (matchDTO.getLeagueId() != null) {
            League league = leagueDAO.findById(matchDTO.getLeagueId());
            if (league != null) {
                existingMatch.setLeague(league);
            }
        }
        
        Match updatedMatch = matchDAO.update(existingMatch);
        return entityMapper.toMatchDTO(updatedMatch);
    }

    public MatchDTO getMatchById(Long id) {
        Match match = matchDAO.findById(id);
        if (match == null) {
            throw new RuntimeException("Match not found with id: " + id);
        }
        return entityMapper.toMatchDTO(match);
    }

    public List<MatchDTO> getAllMatches() {
        List<Match> matches = matchDAO.findAll();
        return entityMapper.toMatchDTOList(matches);
    }

    public void deleteMatch(Long id) {
        Match match = matchDAO.findById(id);
        if (match == null) {
            throw new RuntimeException("Match not found with id: " + id);
        }
        matchDAO.delete(match);
    }

    public List<MatchDTO> getMatchesByTeam(Long teamId) {
        List<Match> matches = matchDAO.findByTeamId(teamId);
        return entityMapper.toMatchDTOList(matches);
    }

    public List<MatchDTO> getMatchesByLeague(Long leagueId) {
        List<Match> matches = matchDAO.findByLeagueId(leagueId);
        return entityMapper.toMatchDTOList(matches);
    }

    public List<MatchDTO> getMatchesByStatus(Match.MatchStatus status) {
        List<Match> matches = matchDAO.findByStatus(status);
        return entityMapper.toMatchDTOList(matches);
    }

    public List<MatchDTO> getMatchesByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        List<Match> matches = matchDAO.findByDateRange(startDate, endDate);
        return entityMapper.toMatchDTOList(matches);
    }

    public List<MatchDTO> getUpcomingMatches() {
        List<Match> matches = matchDAO.findUpcomingMatches();
        return entityMapper.toMatchDTOList(matches);
    }

    public List<MatchDTO> getFinishedMatches() {
        List<Match> matches = matchDAO.findFinishedMatches();
        return entityMapper.toMatchDTOList(matches);
    }

    public List<MatchDTO> getMatchesBetweenTeams(Long homeTeamId, Long awayTeamId) {
        List<Match> matches = matchDAO.findMatchesBetweenTeams(homeTeamId, awayTeamId);
        return entityMapper.toMatchDTOList(matches);
    }

    public MatchDTO updateMatchScore(Long id, int homeScore, int awayScore) {
        Match match = matchDAO.findById(id);
        if (match == null) {
            throw new RuntimeException("Match not found with id: " + id);
        }
        
        match.setHomeTeamScore(homeScore);
        match.setAwayTeamScore(awayScore);
        
        // Automatically set status to finished if both scores are provided and match was in progress
        if (match.getStatus() == Match.MatchStatus.IN_PROGRESS) {
            match.setStatus(Match.MatchStatus.FINISHED);
        }
        
        Match updatedMatch = matchDAO.update(match);
        return entityMapper.toMatchDTO(updatedMatch);
    }
}
