package com.example.sportslibrary.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class MatchDto {
    
    private Long id;
    
    @NotNull(message = "Match date cannot be null")
    private LocalDate matchDate;
    
    @Min(value = 0, message = "Home team score cannot be negative")
    private Integer homeTeamScore;
    
    @Min(value = 0, message = "Away team score cannot be negative")
    private Integer awayTeamScore;
    
    @NotBlank(message = "Status cannot be blank")
    private String status;
    
    // Home team information
    private Long homeTeamId;
    private String homeTeamName;
    private String homeTeamCity;
    
    // Away team information
    private Long awayTeamId;
    private String awayTeamName;
    private String awayTeamCity;
    
    // League information
    private Long leagueId;
    private String leagueName;
    private String leagueCountry;
    
    public MatchDto() {}
    
    public MatchDto(Long id, LocalDate matchDate, Integer homeTeamScore, Integer awayTeamScore, String status) {
        this.id = id;
        this.matchDate = matchDate;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
        this.status = status;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
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
    
    public String getHomeTeamName() {
        return homeTeamName;
    }
    
    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }
    
    public String getHomeTeamCity() {
        return homeTeamCity;
    }
    
    public void setHomeTeamCity(String homeTeamCity) {
        this.homeTeamCity = homeTeamCity;
    }
    
    public Long getAwayTeamId() {
        return awayTeamId;
    }
    
    public void setAwayTeamId(Long awayTeamId) {
        this.awayTeamId = awayTeamId;
    }
    
    public String getAwayTeamName() {
        return awayTeamName;
    }
    
    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }
    
    public String getAwayTeamCity() {
        return awayTeamCity;
    }
    
    public void setAwayTeamCity(String awayTeamCity) {
        this.awayTeamCity = awayTeamCity;
    }
    
    public Long getLeagueId() {
        return leagueId;
    }
    
    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }
    
    public String getLeagueName() {
        return leagueName;
    }
    
    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }
    
    public String getLeagueCountry() {
        return leagueCountry;
    }
    
    public void setLeagueCountry(String leagueCountry) {
        this.leagueCountry = leagueCountry;
    }
}
