package com.football.leaguemanagement.service;

import com.football.leaguemanagement.dto.MatchDTO;
import com.football.leaguemanagement.entity.Match;
import com.football.leaguemanagement.entity.League;
import com.football.leaguemanagement.entity.Team;
import com.football.leaguemanagement.mapper.MatchMapper;
import com.football.leaguemanagement.repository.MatchRepository;
import com.football.leaguemanagement.repository.LeagueRepository;
import com.football.leaguemanagement.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class MatchService {

    private final MatchRepository matchRepository;
    private final LeagueRepository leagueRepository;
    private final TeamRepository teamRepository;
    private final MatchMapper matchMapper;

    @Autowired
    public MatchService(MatchRepository matchRepository,
                       LeagueRepository leagueRepository,
                       TeamRepository teamRepository,
                       MatchMapper matchMapper) {
        this.matchRepository = matchRepository;
        this.leagueRepository = leagueRepository;
        this.teamRepository = teamRepository;
        this.matchMapper = matchMapper;
    }

    public List<MatchDTO> getAllMatches() {
        return matchRepository.findAll().stream()
                .map(matchMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<MatchDTO> getMatchById(Long id) {
        return matchRepository.findById(id)
                .map(matchMapper::toDTO);
    }

    public List<MatchDTO> getMatchesByLeague(Long leagueId) {
        return matchRepository.findByLeagueId(leagueId).stream()
                .map(matchMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<MatchDTO> getMatchesByStatus(String status) {
        return matchRepository.findByStatus(status).stream()
                .map(matchMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<MatchDTO> getMatchesByRound(Integer round) {
        return matchRepository.findByRound(round).stream()
                .map(matchMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<MatchDTO> getMatchesByTeam(Long teamId) {
        return matchRepository.findByTeamId(teamId).stream()
                .map(matchMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<MatchDTO> getHomeMatchesByTeam(Long teamId) {
        return matchRepository.findHomeMatchesByTeamId(teamId).stream()
                .map(matchMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<MatchDTO> getAwayMatchesByTeam(Long teamId) {
        return matchRepository.findAwayMatchesByTeamId(teamId).stream()
                .map(matchMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<MatchDTO> getMatchesByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return matchRepository.findByDateRange(startDate, endDate).stream()
                .map(matchMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<MatchDTO> getMatchesByLeagueAndRound(Long leagueId, Integer round) {
        return matchRepository.findByLeagueAndRound(leagueId, round).stream()
                .map(matchMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<MatchDTO> getMatchesBetweenTeams(Long team1Id, Long team2Id) {
        return matchRepository.findMatchesBetweenTeams(team1Id, team2Id).stream()
                .map(matchMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MatchDTO createMatch(MatchDTO matchDTO) {
        // Validate teams exist
        Team homeTeam = teamRepository.findById(matchDTO.getHomeTeamId())
                .orElseThrow(() -> new IllegalArgumentException("Home team not found with id: " + matchDTO.getHomeTeamId()));
        
        Team awayTeam = teamRepository.findById(matchDTO.getAwayTeamId())
                .orElseThrow(() -> new IllegalArgumentException("Away team not found with id: " + matchDTO.getAwayTeamId()));

        // Validate teams are different
        if (matchDTO.getHomeTeamId().equals(matchDTO.getAwayTeamId())) {
            throw new IllegalArgumentException("Home team and away team cannot be the same");
        }

        Match match = matchMapper.toEntity(matchDTO);
        match.setHomeTeam(homeTeam);
        match.setAwayTeam(awayTeam);

        // Set league if provided
        if (matchDTO.getLeagueId() != null) {
            League league = leagueRepository.findById(matchDTO.getLeagueId())
                    .orElseThrow(() -> new IllegalArgumentException("League not found with id: " + matchDTO.getLeagueId()));
            match.setLeague(league);
        }

        // Set default values if not provided
        if (match.getStatus() == null) {
            match.setStatus("SCHEDULED");
        }
        if (match.getHomeTeamScore() == null) {
            match.setHomeTeamScore(0);
        }
        if (match.getAwayTeamScore() == null) {
            match.setAwayTeamScore(0);
        }

        Match savedMatch = matchRepository.save(match);
        return matchMapper.toDTO(savedMatch);
    }

    public Optional<MatchDTO> updateMatch(Long id, MatchDTO matchDTO) {
        return matchRepository.findById(id)
                .map(existingMatch -> {
                    // Validate teams if they are being changed
                    if (matchDTO.getHomeTeamId() != null) {
                        Team homeTeam = teamRepository.findById(matchDTO.getHomeTeamId())
                                .orElseThrow(() -> new IllegalArgumentException("Home team not found with id: " + matchDTO.getHomeTeamId()));
                        existingMatch.setHomeTeam(homeTeam);
                    }

                    if (matchDTO.getAwayTeamId() != null) {
                        Team awayTeam = teamRepository.findById(matchDTO.getAwayTeamId())
                                .orElseThrow(() -> new IllegalArgumentException("Away team not found with id: " + matchDTO.getAwayTeamId()));
                        existingMatch.setAwayTeam(awayTeam);
                    }

                    // Validate teams are different
                    if (existingMatch.getHomeTeam().getId().equals(existingMatch.getAwayTeam().getId())) {
                        throw new IllegalArgumentException("Home team and away team cannot be the same");
                    }

                    // Update league if provided
                    if (matchDTO.getLeagueId() != null) {
                        League league = leagueRepository.findById(matchDTO.getLeagueId())
                                .orElseThrow(() -> new IllegalArgumentException("League not found with id: " + matchDTO.getLeagueId()));
                        existingMatch.setLeague(league);
                    }

                    matchMapper.updateEntityFromDTO(matchDTO, existingMatch);
                    Match updatedMatch = matchRepository.save(existingMatch);
                    return matchMapper.toDTO(updatedMatch);
                });
    }

    public boolean deleteMatch(Long id) {
        if (matchRepository.existsById(id)) {
            matchRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean existsById(Long id) {
        return matchRepository.existsById(id);
    }
}
