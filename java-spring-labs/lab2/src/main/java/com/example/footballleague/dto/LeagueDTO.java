package com.example.footballleague.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeagueDTO {
    private Long id;
    
    @NotBlank(message = "League name is required")
    private String name;
    
    private String description;
    private String country;
    private List<Long> teamIds;
    private List<Long> matchIds;
}
