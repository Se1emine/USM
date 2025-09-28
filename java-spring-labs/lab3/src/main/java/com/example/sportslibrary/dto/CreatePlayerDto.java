package com.example.sportslibrary.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreatePlayerDto {
    
    @NotBlank(message = "First name cannot be blank")
    private String firstName;
    
    @NotBlank(message = "Last name cannot be blank")
    private String lastName;
    
    @NotBlank(message = "Position cannot be blank")
    private String position;
    
    @Min(value = 1, message = "Age must be at least 1")
    @Max(value = 49, message = "Age must be less than 50")
    private Integer age;
    
    @NotNull(message = "Team ID cannot be null")
    private Long teamId;
    
    // Player statistics (optional, defaults will be used if not provided)
    @Valid
    private PlayerStatisticsDto statistics;
    
    public CreatePlayerDto() {}
    
    public CreatePlayerDto(String firstName, String lastName, String position, Integer age, Long teamId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.age = age;
        this.teamId = teamId;
    }
    
    // Getters and Setters
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
    
    public PlayerStatisticsDto getStatistics() {
        return statistics;
    }
    
    public void setStatistics(PlayerStatisticsDto statistics) {
        this.statistics = statistics;
    }
}
