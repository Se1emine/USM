package com.example.footballleague.service;

import com.example.footballleague.dao.CoachDAO;
import com.example.footballleague.dao.TeamDAO;
import com.example.footballleague.dto.CoachDTO;
import com.example.footballleague.entity.Coach;
import com.example.footballleague.entity.Team;
import com.example.footballleague.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CoachService {

    @Autowired
    private CoachDAO coachDAO;

    @Autowired
    private TeamDAO teamDAO;

    @Autowired
    private EntityMapper entityMapper;

    public CoachDTO createCoach(CoachDTO coachDTO) {
        Coach coach = entityMapper.toCoach(coachDTO);
        
        // Set team if provided
        if (coachDTO.getTeamId() != null) {
            Team team = teamDAO.findById(coachDTO.getTeamId());
            if (team != null) {
                coach.setTeam(team);
            }
        }
        
        Coach savedCoach = coachDAO.save(coach);
        return entityMapper.toCoachDTO(savedCoach);
    }

    public CoachDTO updateCoach(Long id, CoachDTO coachDTO) {
        Coach existingCoach = coachDAO.findById(id);
        if (existingCoach == null) {
            throw new RuntimeException("Coach not found with id: " + id);
        }
        
        existingCoach.setFirstName(coachDTO.getFirstName());
        existingCoach.setLastName(coachDTO.getLastName());
        existingCoach.setBirthDate(coachDTO.getBirthDate());
        existingCoach.setNationality(coachDTO.getNationality());
        existingCoach.setExperienceYears(coachDTO.getExperienceYears());
        
        // Update team if provided
        if (coachDTO.getTeamId() != null) {
            Team team = teamDAO.findById(coachDTO.getTeamId());
            if (team != null) {
                existingCoach.setTeam(team);
            }
        }
        
        Coach updatedCoach = coachDAO.update(existingCoach);
        return entityMapper.toCoachDTO(updatedCoach);
    }

    public CoachDTO getCoachById(Long id) {
        Coach coach = coachDAO.findById(id);
        if (coach == null) {
            throw new RuntimeException("Coach not found with id: " + id);
        }
        return entityMapper.toCoachDTO(coach);
    }

    public List<CoachDTO> getAllCoaches() {
        List<Coach> coaches = coachDAO.findAll();
        return entityMapper.toCoachDTOList(coaches);
    }

    public void deleteCoach(Long id) {
        Coach coach = coachDAO.findById(id);
        if (coach == null) {
            throw new RuntimeException("Coach not found with id: " + id);
        }
        coachDAO.delete(coach);
    }

    public List<CoachDTO> getCoachesByNationality(String nationality) {
        List<Coach> coaches = coachDAO.findByNationality(nationality);
        return entityMapper.toCoachDTOList(coaches);
    }

    public List<CoachDTO> getCoachesByExperience(int minYears) {
        List<Coach> coaches = coachDAO.findByExperienceYears(minYears);
        return entityMapper.toCoachDTOList(coaches);
    }

    public List<CoachDTO> getCoachesWithoutTeam() {
        List<Coach> coaches = coachDAO.findCoachesWithoutTeam();
        return entityMapper.toCoachDTOList(coaches);
    }

    public List<CoachDTO> getCoachesByFullName(String firstName, String lastName) {
        List<Coach> coaches = coachDAO.findByFullName(firstName, lastName);
        return entityMapper.toCoachDTOList(coaches);
    }
}
