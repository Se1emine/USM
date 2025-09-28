package com.example.sportslibrary.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

public class TeamDto {
    
    private Long id;
    
    @NotBlank(message = "Team name cannot be blank")
    private String name;
    
    @NotBlank(message = "City cannot be blank")
    private String city;
    
    @Min(value = 1800, message = "Founded year must be after 1800")
    private Integer foundedYear;
    
    // Coach information
    private CoachDto coach;
    
    // League information
    private Long leagueId;
    private String leagueName;
    private String leagueCountry;
    private String leagueSeason;
    
    // Players list
    private List<PlayerDto> players;
    
    // Matches list (both home and away)
    private List<MatchDto> matches;
    
    public TeamDto() {}
    
    public TeamDto(Long id, String name, String city, Integer foundedYear) {
        this.id = id;
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
    
    public CoachDto getCoach() {
        return coach;
    }
    
    public void setCoach(CoachDto coach) {
        this.coach = coach;
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
    
    public String getLeagueSeason() {
        return leagueSeason;
    }
    
    public void setLeagueSeason(String leagueSeason) {
        this.leagueSeason = leagueSeason;
    }
    
    public List<PlayerDto> getPlayers() {
        return players;
    }
    
    public void setPlayers(List<PlayerDto> players) {
        this.players = players;
    }
    
    public List<MatchDto> getMatches() {
        return matches;
    }
    
    public void setMatches(List<MatchDto> matches) {
        this.matches = matches;
    }
}
