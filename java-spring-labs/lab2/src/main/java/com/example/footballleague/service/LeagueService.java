package com.example.footballleague.service;

import com.example.footballleague.dao.LeagueDAO;
import com.example.footballleague.dto.LeagueDTO;
import com.example.footballleague.entity.League;
import com.example.footballleague.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LeagueService {

    @Autowired
    private LeagueDAO leagueDAO;

    @Autowired
    private EntityMapper entityMapper;

    public LeagueDTO createLeague(LeagueDTO leagueDTO) {
        League league = entityMapper.toLeague(leagueDTO);
        League savedLeague = leagueDAO.save(league);
        return entityMapper.toLeagueDTO(savedLeague);
    }

    public LeagueDTO updateLeague(Long id, LeagueDTO leagueDTO) {
        League existingLeague = leagueDAO.findById(id);
        if (existingLeague == null) {
            throw new RuntimeException("League not found with id: " + id);
        }
        
        existingLeague.setName(leagueDTO.getName());
        existingLeague.setDescription(leagueDTO.getDescription());
        existingLeague.setCountry(leagueDTO.getCountry());
        
        League updatedLeague = leagueDAO.update(existingLeague);
        return entityMapper.toLeagueDTO(updatedLeague);
    }

    public LeagueDTO getLeagueById(Long id) {
        League league = leagueDAO.findById(id);
        if (league == null) {
            throw new RuntimeException("League not found with id: " + id);
        }
        return entityMapper.toLeagueDTO(league);
    }

    public List<LeagueDTO> getAllLeagues() {
        List<League> leagues = leagueDAO.findAll();
        return entityMapper.toLeagueDTOList(leagues);
    }

    public void deleteLeague(Long id) {
        League league = leagueDAO.findById(id);
        if (league == null) {
            throw new RuntimeException("League not found with id: " + id);
        }
        leagueDAO.delete(league);
    }

    public LeagueDTO getLeagueByName(String name) {
        League league = leagueDAO.findByName(name);
        if (league == null) {
            throw new RuntimeException("League not found with name: " + name);
        }
        return entityMapper.toLeagueDTO(league);
    }

    public List<LeagueDTO> getLeaguesByCountry(String country) {
        List<League> leagues = leagueDAO.findByCountry(country);
        return entityMapper.toLeagueDTOList(leagues);
    }

    public List<LeagueDTO> getLeaguesWithTeams() {
        List<League> leagues = leagueDAO.findLeaguesWithTeams();
        return entityMapper.toLeagueDTOList(leagues);
    }
}
