package com.football.leaguemanagement.service;

import com.football.leaguemanagement.dto.CoachDTO;
import com.football.leaguemanagement.entity.Coach;
import com.football.leaguemanagement.mapper.CoachMapper;
import com.football.leaguemanagement.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CoachService {

    private final CoachRepository coachRepository;
    private final CoachMapper coachMapper;

    @Autowired
    public CoachService(CoachRepository coachRepository, CoachMapper coachMapper) {
        this.coachRepository = coachRepository;
        this.coachMapper = coachMapper;
    }

    public List<CoachDTO> getAllCoaches() {
        return coachRepository.findAll().stream()
                .map(coachMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<CoachDTO> getCoachById(Long id) {
        return coachRepository.findById(id)
                .map(coachMapper::toDTO);
    }

    public Optional<CoachDTO> getCoachByName(String name) {
        return coachRepository.findByName(name)
                .map(coachMapper::toDTO);
    }

    public List<CoachDTO> getCoachesByNationality(String nationality) {
        return coachRepository.findByNationality(nationality).stream()
                .map(coachMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<CoachDTO> getCoachesByMinimumExperience(int minExperience) {
        return coachRepository.findByMinimumExperience(minExperience).stream()
                .map(coachMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<CoachDTO> getCoachesByAgeRange(int minAge, int maxAge) {
        return coachRepository.findByAgeRange(minAge, maxAge).stream()
                .map(coachMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<CoachDTO> getAvailableCoaches() {
        return coachRepository.findAvailableCoaches().stream()
                .map(coachMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<CoachDTO> getCoachesWithTeams() {
        return coachRepository.findCoachesWithTeams().stream()
                .map(coachMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CoachDTO createCoach(CoachDTO coachDTO) {
        Coach coach = coachMapper.toEntity(coachDTO);
        Coach savedCoach = coachRepository.save(coach);
        return coachMapper.toDTO(savedCoach);
    }

    public Optional<CoachDTO> updateCoach(Long id, CoachDTO coachDTO) {
        return coachRepository.findById(id)
                .map(existingCoach -> {
                    coachMapper.updateEntityFromDTO(coachDTO, existingCoach);
                    Coach updatedCoach = coachRepository.save(existingCoach);
                    return coachMapper.toDTO(updatedCoach);
                });
    }

    public boolean deleteCoach(Long id) {
        if (coachRepository.existsById(id)) {
            coachRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean existsById(Long id) {
        return coachRepository.existsById(id);
    }
}
