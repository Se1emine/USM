package com.example.sportslibrary.dto;

import jakarta.validation.constraints.NotBlank;
import java.util.List;

public class LeagueDto {
    
    private Long id;
    
    @NotBlank(message = "League name cannot be blank")
    private String name;
    
    @NotBlank(message = "Country cannot be blank")
    private String country;
    
    @NotBlank(message = "Season cannot be blank")
    private String season;
    
    // Teams in the league
    private List<TeamDto> teams;
    
    // Matches in the league
    private List<MatchDto> matches;
    
    public LeagueDto() {}
    
    public LeagueDto(Long id, String name, String country, String season) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.season = season;
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
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getSeason() {
        return season;
    }
    
    public void setSeason(String season) {
        this.season = season;
    }
    
    public List<TeamDto> getTeams() {
        return teams;
    }
    
    public void setTeams(List<TeamDto> teams) {
        this.teams = teams;
    }
    
    public List<MatchDto> getMatches() {
        return matches;
    }
    
    public void setMatches(List<MatchDto> matches) {
        this.matches = matches;
    }
}
