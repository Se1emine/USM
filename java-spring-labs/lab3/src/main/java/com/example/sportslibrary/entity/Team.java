package com.example.sportslibrary.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team")
public class Team {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Team name cannot be blank")
    @Column(nullable = false)
    private String name;
    
    @NotBlank(message = "City cannot be blank")
    @Column(nullable = false)
    private String city;
    
    @Min(value = 1800, message = "Founded year must be after 1800")
    @Column(name = "founded_year", nullable = false)
    private Integer foundedYear;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "coach_id", unique = true)
    private Coach coach;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "league_id", nullable = false)
    private League league;
    
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Player> players = new ArrayList<>();
    
    @OneToMany(mappedBy = "homeTeam", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Match> homeMatches = new ArrayList<>();
    
    @OneToMany(mappedBy = "awayTeam", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Match> awayMatches = new ArrayList<>();
    
    public Team() {}
    
    public Team(String name, String city, Integer foundedYear) {
        this.name = name;
        this.city = city;
        this.foundedYear = foundedYear;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
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
    
    public Coach getCoach() {
        return coach;
    }
    
    public void setCoach(Coach coach) {
        this.coach = coach;
    }
    
    public League getLeague() {
        return league;
    }
    
    public void setLeague(League league) {
        this.league = league;
    }
    
    public List<Player> getPlayers() {
        return players;
    }
    
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    
    public List<Match> getHomeMatches() {
        return homeMatches;
    }
    
    public void setHomeMatches(List<Match> homeMatches) {
        this.homeMatches = homeMatches;
    }
    
    public List<Match> getAwayMatches() {
        return awayMatches;
    }
    
    public void setAwayMatches(List<Match> awayMatches) {
        this.awayMatches = awayMatches;
    }
}
