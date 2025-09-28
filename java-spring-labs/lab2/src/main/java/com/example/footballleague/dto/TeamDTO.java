package com.example.footballleague.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamDTO {
    private Long id;
    
    @NotBlank(message = "Team name is required")
    private String name;
    
    private String city;
    private LocalDate foundedDate;
    private String stadium;
    private Long coachId;
    private Long leagueId;
    private List<Long> playerIds;
}
