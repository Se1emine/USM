package com.example.sportslibrary.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Min;

@Embeddable
public class PlayerStatistics {
    
    @Min(value = 0, message = "Goals cannot be negative")
    private Integer goals = 0;
    
    @Min(value = 0, message = "Assists cannot be negative")
    private Integer assists = 0;
    
    @Min(value = 0, message = "Matches played cannot be negative")
    private Integer matchesPlayed = 0;
    
    public PlayerStatistics() {}
    
    public PlayerStatistics(Integer goals, Integer assists, Integer matchesPlayed) {
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
