package com.example.sportslibrary.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "match")
public class Match {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "Match date cannot be null")
    @Column(name = "match_date", nullable = false)
    private LocalDate matchDate;
    
    @Min(value = 0, message = "Home team score cannot be negative")
    @Column(name = "home_team_score")
    private Integer homeTeamScore = 0;
    
    @Min(value = 0, message = "Away team score cannot be negative")
    @Column(name = "away_team_score")
    private Integer awayTeamScore = 0;
    
    @NotBlank(message = "Status cannot be blank")
    @Column(nullable = false)
    private String status;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_team_id", nullable = false)
    private Team homeTeam;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "away_team_id", nullable = false)
    private Team awayTeam;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "league_id", nullable = false)
    private League league;
    
    public Match() {}
    
    public Match(LocalDate matchDate, String status) {
        this.matchDate = matchDate;
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
    
    public Team getHomeTeam() {
        return homeTeam;
    }
    
    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }
    
    public Team getAwayTeam() {
        return awayTeam;
    }
    
    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }
    
    public League getLeague() {
        return league;
    }
    
    public void setLeague(League league) {
        this.league = league;
    }
}
