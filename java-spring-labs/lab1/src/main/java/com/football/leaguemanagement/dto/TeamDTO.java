package com.football.leaguemanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import java.util.List;

public class TeamDTO {
    private Long id;

    @NotBlank(message = "Team name is required")
    private String name;

    private String city;

    @Min(value = 1800, message = "Founded year must be after 1800")
    private Integer foundedYear;

    private String stadium;

    private Long leagueId;
    private Long coachId;
    private List<Long> playerIds;

    public TeamDTO() {}

    public TeamDTO(Long id, String name, String city, Integer foundedYear, String stadium) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.foundedYear = foundedYear;
        this.stadium = stadium;
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

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public Long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }

    public Long getCoachId() {
        return coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }

    public List<Long> getPlayerIds() {
        return playerIds;
    }

    public void setPlayerIds(List<Long> playerIds) {
        this.playerIds = playerIds;
    }
}
