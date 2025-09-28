package com.example.footballleague.service;

import com.example.footballleague.dao.CoachDAO;
import com.example.footballleague.dao.LeagueDAO;
import com.example.footballleague.dao.TeamDAO;
import com.example.footballleague.dto.TeamDTO;
import com.example.footballleague.entity.Coach;
import com.example.footballleague.entity.League;
import com.example.footballleague.entity.Team;
import com.example.footballleague.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeamService {

    @Autowired
    private TeamDAO teamDAO;

    @Autowired
    private LeagueDAO leagueDAO;

    @Autowired
    private CoachDAO coachDAO;

    @Autowired
    private EntityMapper entityMapper;

    public TeamDTO createTeam(TeamDTO teamDTO) {
        Team team = entityMapper.toTeam(teamDTO);
        
        // Set league if provided
        if (teamDTO.getLeagueId() != null) {
            League league = leagueDAO.findById(teamDTO.getLeagueId());
            if (league != null) {
                team.setLeague(league);
            }
        }
        
        // Set coach if provided
        if (teamDTO.getCoachId() != null) {
            Coach coach = coachDAO.findById(teamDTO.getCoachId());
            if (coach != null) {
                team.setCoach(coach);
            }
        }
        
        Team savedTeam = teamDAO.save(team);
        return entityMapper.toTeamDTO(savedTeam);
    }

    public TeamDTO updateTeam(Long id, TeamDTO teamDTO) {
        Team existingTeam = teamDAO.findById(id);
        if (existingTeam == null) {
            throw new RuntimeException("Team not found with id: " + id);
        }
        
        existingTeam.setName(teamDTO.getName());
        existingTeam.setCity(teamDTO.getCity());
        existingTeam.setFoundedDate(teamDTO.getFoundedDate());
        existingTeam.setStadium(teamDTO.getStadium());
        
        // Update league if provided
        if (teamDTO.getLeagueId() != null) {
            League league = leagueDAO.findById(teamDTO.getLeagueId());
            if (league != null) {
                existingTeam.setLeague(league);
            }
        }
        
        // Update coach if provided
        if (teamDTO.getCoachId() != null) {
            Coach coach = coachDAO.findById(teamDTO.getCoachId());
            if (coach != null) {
                existingTeam.setCoach(coach);
            }
        }
        
        Team updatedTeam = teamDAO.update(existingTeam);
        return entityMapper.toTeamDTO(updatedTeam);
    }

    public TeamDTO getTeamById(Long id) {
        Team team = teamDAO.findById(id);
        if (team == null) {
            throw new RuntimeException("Team not found with id: " + id);
        }
        return entityMapper.toTeamDTO(team);
    }

    public List<TeamDTO> getAllTeams() {
        List<Team> teams = teamDAO.findAll();
        return entityMapper.toTeamDTOList(teams);
    }

    public void deleteTeam(Long id) {
        Team team = teamDAO.findById(id);
        if (team == null) {
            throw new RuntimeException("Team not found with id: " + id);
        }
        teamDAO.delete(team);
    }

    public TeamDTO getTeamByName(String name) {
        Team team = teamDAO.findByName(name);
        if (team == null) {
            throw new RuntimeException("Team not found with name: " + name);
        }
        return entityMapper.toTeamDTO(team);
    }

    public List<TeamDTO> getTeamsByCity(String city) {
        List<Team> teams = teamDAO.findByCity(city);
        return entityMapper.toTeamDTOList(teams);
    }

    public List<TeamDTO> getTeamsByLeague(Long leagueId) {
        List<Team> teams = teamDAO.findByLeagueId(leagueId);
        return entityMapper.toTeamDTOList(teams);
    }

    public List<TeamDTO> getTeamsWithPlayers() {
        List<Team> teams = teamDAO.findTeamsWithPlayers();
        return entityMapper.toTeamDTOList(teams);
    }

    public List<TeamDTO> getTeamsWithCoach() {
        List<Team> teams = teamDAO.findTeamsWithCoach();
        return entityMapper.toTeamDTOList(teams);
    }
}
