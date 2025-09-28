package com.football.leaguemanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class LeagueDTO {
    private Long id;

    @NotBlank(message = "League name is required")
    private String name;

    private String country;

    @NotNull(message = "Season is required")
    private Integer season;

    private List<Long> teamIds;
    private List<Long> matchIds;

    public LeagueDTO() {}

    public LeagueDTO(Long id, String name, String country, Integer season) {
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

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public List<Long> getTeamIds() {
        return teamIds;
    }

    public void setTeamIds(List<Long> teamIds) {
        this.teamIds = teamIds;
    }

    public List<Long> getMatchIds() {
        return matchIds;
    }

    public void setMatchIds(List<Long> matchIds) {
        this.matchIds = matchIds;
    }
}
