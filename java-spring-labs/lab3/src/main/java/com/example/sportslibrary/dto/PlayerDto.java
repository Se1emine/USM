package com.example.sportslibrary.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class PlayerDto {
    
    private Long id;
    
    @NotBlank(message = "First name cannot be blank")
    private String firstName;
    
    @NotBlank(message = "Last name cannot be blank")
    private String lastName;
    
    @NotBlank(message = "Position cannot be blank")
    private String position;
    
    @Min(value = 1, message = "Age must be at least 1")
    @Max(value = 49, message = "Age must be less than 50")
    private Integer age;
    
    // Team information
    private Long teamId;
    private String teamName;
    private String teamCity;
    
    // Player statistics
    @Valid
    private PlayerStatisticsDto statistics;
    
    public PlayerDto() {}
    
    public PlayerDto(Long id, String firstName, String lastName, String position, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.age = age;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getPosition() {
        return position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public Long getTeamId() {
        return teamId;
    }
    
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
    
    public String getTeamName() {
        return teamName;
    }
    
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    
    public String getTeamCity() {
        return teamCity;
    }
    
    public void setTeamCity(String teamCity) {
        this.teamCity = teamCity;
    }
    
    public PlayerStatisticsDto getStatistics() {
        return statistics;
    }
    
    public void setStatistics(PlayerStatisticsDto statistics) {
        this.statistics = statistics;
    }
}
