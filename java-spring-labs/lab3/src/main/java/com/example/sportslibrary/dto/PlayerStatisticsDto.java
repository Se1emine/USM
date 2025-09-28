package com.example.sportslibrary.dto;

import jakarta.validation.constraints.Min;

public class PlayerStatisticsDto {
    
    @Min(value = 0, message = "Goals cannot be negative")
    private Integer goals;
    
    @Min(value = 0, message = "Assists cannot be negative")
    private Integer assists;
    
    @Min(value = 0, message = "Matches played cannot be negative")
    private Integer matchesPlayed;
    
    public PlayerStatisticsDto() {}
    
    public PlayerStatisticsDto(Integer goals, Integer assists, Integer matchesPlayed) {
        this.goals = goals;
        this.assists = assists;
        this.matchesPlayed = matchesPlayed;
    }
    
    // Getters and Setters
    public Integer getGoals() {
        return goals;
    }
    
    public void setGoals(Integer goals) {
        this.goals = goals;
    }
    
    public Integer getAssists() {
        return assists;
    }
    
    public void setAssists(Integer assists) {
        this.assists = assists;
    }
    
    public Integer getMatchesPlayed() {
        return matchesPlayed;
    }
    
    public void setMatchesPlayed(Integer matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }
}
