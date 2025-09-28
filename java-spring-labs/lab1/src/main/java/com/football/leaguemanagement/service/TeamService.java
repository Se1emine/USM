package com.football.leaguemanagement.service;

import com.football.leaguemanagement.dto.TeamDTO;
import com.football.leaguemanagement.entity.Team;
import com.football.leaguemanagement.entity.League;
import com.football.leaguemanagement.entity.Coach;
import com.football.leaguemanagement.mapper.TeamMapper;
import com.football.leaguemanagement.repository.TeamRepository;
import com.football.leaguemanagement.repository.LeagueRepository;
import com.football.leaguemanagement.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TeamService {

    private final TeamRepository teamRepository;
    private final LeagueRepository leagueRepository;
    private final CoachRepository coachRepository;
    private final TeamMapper teamMapper;

    @Autowired
    public TeamService(TeamRepository teamRepository, 
                      LeagueRepository leagueRepository,
                      CoachRepository coachRepository,
                      TeamMapper teamMapper) {
        this.teamRepository = teamRepository;
        this.leagueRepository = leagueRepository;
        this.coachRepository = coachRepository;
        this.teamMapper = teamMapper;
    }

    public List<TeamDTO> getAllTeams() {
        return teamRepository.findAll().stream()
                .map(teamMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<TeamDTO> getTeamById(Long id) {
        return teamRepository.findById(id)
                .map(teamMapper::toDTO);
    }

    public Optional<TeamDTO> getTeamByName(String name) {
        return teamRepository.findByName(name)
                .map(teamMapper::toDTO);
    }

    public List<TeamDTO> getTeamsByCity(String city) {
        return teamRepository.findByCity(city).stream()
                .map(teamMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<TeamDTO> getTeamsByLeague(Long leagueId) {
        return teamRepository.findByLeagueId(leagueId).stream()
                .map(teamMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TeamDTO createTeam(TeamDTO teamDTO) {
        if (teamRepository.existsByName(teamDTO.getName())) {
            throw new IllegalArgumentException("Team with name '" + teamDTO.getName() + "' already exists");
        }

        Team team = teamMapper.toEntity(teamDTO);

        // Set league if provided
        if (teamDTO.getLeagueId() != null) {
            League league = leagueRepository.findById(teamDTO.getLeagueId())
                    .orElseThrow(() -> new IllegalArgumentException("League not found with id: " + teamDTO.getLeagueId()));
            team.setLeague(league);
        }

        // Set coach if provided
        if (teamDTO.getCoachId() != null) {
            Coach coach = coachRepository.findById(teamDTO.getCoachId())
                    .orElseThrow(() -> new IllegalArgumentException("Coach not found with id: " + teamDTO.getCoachId()));
            
            // Check if coach is already assigned to another team
            if (coach.getTeam() != null) {
                throw new IllegalArgumentException("Coach is already assigned to team: " + coach.getTeam().getName());
            }
            
            team.setCoach(coach);
        }

        Team savedTeam = teamRepository.save(team);
        return teamMapper.toDTO(savedTeam);
    }

    public Optional<TeamDTO> updateTeam(Long id, TeamDTO teamDTO) {
        return teamRepository.findById(id)
                .map(existingTeam -> {
                    // Check if name is being changed and if new name already exists
                    if (!existingTeam.getName().equals(teamDTO.getName()) && 
                        teamRepository.existsByName(teamDTO.getName())) {
                        throw new IllegalArgumentException("Team with name '" + teamDTO.getName() + "' already exists");
                    }

                    teamMapper.updateEntityFromDTO(teamDTO, existingTeam);

                    // Update league if provided
                    if (teamDTO.getLeagueId() != null) {
                        League league = leagueRepository.findById(teamDTO.getLeagueId())
                                .orElseThrow(() -> new IllegalArgumentException("League not found with id: " + teamDTO.getLeagueId()));
                        existingTeam.setLeague(league);
                    }

                    // Update coach if provided
                    if (teamDTO.getCoachId() != null) {
                        Coach coach = coachRepository.findById(teamDTO.getCoachId())
                                .orElseThrow(() -> new IllegalArgumentException("Coach not found with id: " + teamDTO.getCoachId()));
                        
                        // Check if coach is already assigned to another team (excluding current team)
                        if (coach.getTeam() != null && !coach.getTeam().getId().equals(id)) {
                            throw new IllegalArgumentException("Coach is already assigned to team: " + coach.getTeam().getName());
                        }
                        
                        existingTeam.setCoach(coach);
                    }

                    Team updatedTeam = teamRepository.save(existingTeam);
                    return teamMapper.toDTO(updatedTeam);
                });
    }

    public boolean deleteTeam(Long id) {
        if (teamRepository.existsById(id)) {
            teamRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean existsById(Long id) {
        return teamRepository.existsById(id);
    }

    public boolean existsByName(String name) {
        return teamRepository.existsByName(name);
    }

    public long countTeamsByLeague(Long leagueId) {
        return teamRepository.countByLeagueId(leagueId);
    }
}
