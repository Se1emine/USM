package com.football.leaguemanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

public class PlayerDTO {
    private Long id;

    @NotBlank(message = "Player name is required")
    private String name;

    @Min(value = 16, message = "Player age must be at least 16")
    @Max(value = 50, message = "Player age must be at most 50")
    private Integer age;

    private String position;

    @Min(value = 1, message = "Jersey number must be at least 1")
    @Max(value = 99, message = "Jersey number must be at most 99")
    private Integer jerseyNumber;

    private String nationality;

    private Long teamId;
    private PlayerStatisticsDTO statistics;

    public PlayerDTO() {}

    public PlayerDTO(Long id, String name, Integer age, String position, Integer jerseyNumber, String nationality) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
        this.jerseyNumber = jerseyNumber;
        this.nationality = nationality;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(Integer jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public PlayerStatisticsDTO getStatistics() {
        return statistics;
    }

    public void setStatistics(PlayerStatisticsDTO statistics) {
        this.statistics = statistics;
    }
}
