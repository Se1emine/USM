package com.football.leaguemanagement.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import java.time.LocalDateTime;

public class MatchDTO {
    private Long id;

    @NotNull(message = "Match date is required")
    private LocalDateTime matchDate;

    @Min(value = 0, message = "Score cannot be negative")
    private Integer homeTeamScore;

    @Min(value = 0, message = "Score cannot be negative")
    private Integer awayTeamScore;

    private String status;

    @Min(value = 1, message = "Round must be at least 1")
    private Integer round;

    @NotNull(message = "League ID is required")
    private Long leagueId;

    @NotNull(message = "Home team ID is required")
    private Long homeTeamId;

    @NotNull(message = "Away team ID is required")
    private Long awayTeamId;

    // Team names for display purposes
    private String homeTeamName;
    private String awayTeamName;
    private String leagueName;

    public MatchDTO() {}

    public MatchDTO(Long id, LocalDateTime matchDate, Long homeTeamId, Long awayTeamId, Long leagueId, Integer round) {
        this.id = id;
        this.matchDate = matchDate;
        this.homeTeamId = homeTeamId;
        this.awayTeamId = awayTeamId;
        this.leagueId = leagueId;
        this.round = round;
        this.status = "SCHEDULED";
        this.homeTeamScore = 0;
        this.awayTeamScore = 0;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDateTime matchDate) {
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

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public Long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
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

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }
}
