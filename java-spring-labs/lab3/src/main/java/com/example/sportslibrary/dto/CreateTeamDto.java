package com.example.sportslibrary.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class CreateTeamDto {
    
    @NotBlank(message = "Team name cannot be blank")
    private String name;
    
    @NotBlank(message = "City cannot be blank")
    private String city;
    
    @Min(value = 1800, message = "Founded year must be after 1800")
    private Integer foundedYear;
    
    // ID of existing coach (optional)
    private Long coachId;
    
    @NotNull(message = "League ID cannot be null")
    private Long leagueId;
    
    // List of existing player IDs (optional)
    private List<Long> playerIds;
    
    public CreateTeamDto() {}
    
    public CreateTeamDto(String name, String city, Integer foundedYear, Long leagueId) {
        this.name = name;
        this.city = city;
        this.foundedYear = foundedYear;
        this.leagueId = leagueId;
    }
    
    // Getters and Setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public Integer getFoundedYear() {
        return foundedYear;
    }
    
    public void setFoundedYear(Integer foundedYear) {
        this.foundedYear = foundedYear;
    }
    
    public Long getCoachId() {
        return coachId;
    }
    
    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }
    
    public Long getLeagueId() {
        return leagueId;
    }
    
    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }
    
    public List<Long> getPlayerIds() {
        return playerIds;
    }
    
    public void setPlayerIds(List<Long> playerIds) {
        this.playerIds = playerIds;
    }
}
