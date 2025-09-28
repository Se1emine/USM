package com.football.leaguemanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;

public class CoachDTO {
    private Long id;

    @NotBlank(message = "Coach name is required")
    private String name;

    @Min(value = 18, message = "Coach age must be at least 18")
    private Integer age;

    private String nationality;

    @Min(value = 0, message = "Experience years cannot be negative")
    private Integer experienceYears;

    private Long teamId;

    public CoachDTO() {}

    public CoachDTO(Long id, String name, Integer age, String nationality, Integer experienceYears) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.experienceYears = experienceYears;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}
