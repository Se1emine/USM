package com.football.leaguemanagement.mapper;

import com.football.leaguemanagement.dto.CoachDTO;
import com.football.leaguemanagement.entity.Coach;
import org.springframework.stereotype.Component;

@Component
public class CoachMapper {

    public CoachDTO toDTO(Coach coach) {
        if (coach == null) {
            return null;
        }

        CoachDTO dto = new CoachDTO();
        dto.setId(coach.getId());
        dto.setName(coach.getName());
        dto.setAge(coach.getAge());
        dto.setNationality(coach.getNationality());
        dto.setExperienceYears(coach.getExperienceYears());

        if (coach.getTeam() != null) {
            dto.setTeamId(coach.getTeam().getId());
        }

        return dto;
    }

    public Coach toEntity(CoachDTO dto) {
        if (dto == null) {
            return null;
        }

        Coach coach = new Coach();
        coach.setId(dto.getId());
        coach.setName(dto.getName());
        coach.setAge(dto.getAge());
        coach.setNationality(dto.getNationality());
        coach.setExperienceYears(dto.getExperienceYears());

        return coach;
    }

    public void updateEntityFromDTO(CoachDTO dto, Coach coach) {
        if (dto == null || coach == null) {
            return;
        }

        coach.setName(dto.getName());
        coach.setAge(dto.getAge());
        coach.setNationality(dto.getNationality());
        coach.setExperienceYears(dto.getExperienceYears());
    }
}
