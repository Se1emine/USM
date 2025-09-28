package com.example.sportslibrary.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class CreateMatchDto {
    
    @NotNull(message = "Match date cannot be null")
    private LocalDate matchDate;
    
    @Min(value = 0, message = "Home team score cannot be negative")
    private Integer homeTeamScore = 0;
    
    @Min(value = 0, message = "Away team score cannot be negative")
    private Integer awayTeamScore = 0;
    
    @NotBlank(message = "Status cannot be blank")
    private String status;
    
    @NotNull(message = "Home team ID cannot be null")
    private Long homeTeamId;
    
    @NotNull(message = "Away team ID cannot be null")
    private Long awayTeamId;
    
    @NotNull(message = "League ID cannot be null")
    private Long leagueId;
    
    public CreateMatchDto() {}
    
    public CreateMatchDto(LocalDate matchDate, String status, Long homeTeamId, Long awayTeamId, Long leagueId) {
        this.matchDate = matchDate;
        this.status = status;
        this.homeTeamId = homeTeamId;
        this.awayTeamId = awayTeamId;
        this.leagueId = leagueId;
    }
    
    // Getters and Setters
    public LocalDate getMatchDate() {
        return matchDate;
    }
    
    public void setMatchDate(LocalDate matchDate) {
        this.matchDate = matchDate;
    }
    
    public Integer getHomeTeamScore() {
        return homeTeamScore;
    }
    
    public void setHomeTeamScore(Integer homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }
    
    public Integer getAwayTeamScore() {
        return awayTeamScore;
    }
    
    public void setAwayTeamScore(Integer awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public Long getHomeTeamId() {
        return homeTeamId;
    }
    
    public void setHomeTeamId(Long homeTeamId) {
        this.homeTeamId = homeTeamId;
    }
    
    public Long getAwayTeamId() {
        return awayTeamId;
    }
    
    public void setAwayTeamId(Long awayTeamId) {
        this.awayTeamId = awayTeamId;
    }
    
    public Long getLeagueId() {
        return leagueId;
    }
    
    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }
}
