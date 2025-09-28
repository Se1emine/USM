package com.football.leaguemanagement.service;

import com.football.leaguemanagement.dto.LeagueDTO;
import com.football.leaguemanagement.entity.League;
import com.football.leaguemanagement.mapper.LeagueMapper;
import com.football.leaguemanagement.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class LeagueService {

    private final LeagueRepository leagueRepository;
    private final LeagueMapper leagueMapper;

    @Autowired
    public LeagueService(LeagueRepository leagueRepository, LeagueMapper leagueMapper) {
        this.leagueRepository = leagueRepository;
        this.leagueMapper = leagueMapper;
    }

    public List<LeagueDTO> getAllLeagues() {
        return leagueRepository.findAll().stream()
                .map(leagueMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<LeagueDTO> getLeagueById(Long id) {
        return leagueRepository.findById(id)
                .map(leagueMapper::toDTO);
    }

    public Optional<LeagueDTO> getLeagueByName(String name) {
        return leagueRepository.findByName(name)
                .map(leagueMapper::toDTO);
    }

    public List<LeagueDTO> getLeaguesByCountry(String country) {
        return leagueRepository.findByCountry(country).stream()
                .map(leagueMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<LeagueDTO> getLeaguesBySeason(Integer season) {
        return leagueRepository.findBySeason(season).stream()
                .map(leagueMapper::toDTO)
                .collect(Collectors.toList());
    }

    public LeagueDTO createLeague(LeagueDTO leagueDTO) {
        if (leagueRepository.existsByName(leagueDTO.getName())) {
            throw new IllegalArgumentException("League with name '" + leagueDTO.getName() + "' already exists");
        }

        League league = leagueMapper.toEntity(leagueDTO);
        League savedLeague = leagueRepository.save(league);
        return leagueMapper.toDTO(savedLeague);
    }

    public Optional<LeagueDTO> updateLeague(Long id, LeagueDTO leagueDTO) {
        return leagueRepository.findById(id)
                .map(existingLeague -> {
                    // Check if name is being changed and if new name already exists
                    if (!existingLeague.getName().equals(leagueDTO.getName()) && 
                        leagueRepository.existsByName(leagueDTO.getName())) {
                        throw new IllegalArgumentException("League with name '" + leagueDTO.getName() + "' already exists");
                    }
                    
                    leagueMapper.updateEntityFromDTO(leagueDTO, existingLeague);
                    League updatedLeague = leagueRepository.save(existingLeague);
                    return leagueMapper.toDTO(updatedLeague);
                });
    }

    public boolean deleteLeague(Long id) {
        if (leagueRepository.existsById(id)) {
            leagueRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean existsById(Long id) {
        return leagueRepository.existsById(id);
    }

    public boolean existsByName(String name) {
        return leagueRepository.existsByName(name);
    }
}
