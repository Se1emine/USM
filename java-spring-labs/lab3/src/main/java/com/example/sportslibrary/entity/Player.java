package com.example.sportslibrary.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "player")
public class Player {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "First name cannot be blank")
    @Column(name = "first_name", nullable = false)
    private String firstName;
    
    @NotBlank(message = "Last name cannot be blank")
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @NotBlank(message = "Position cannot be blank")
    @Column(nullable = false)
    private String position;
    
    @Min(value = 1, message = "Age must be at least 1")
    @Max(value = 49, message = "Age must be less than 50")
    @Column(nullable = false)
    private Integer age;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;
    
    @Valid
    @Embedded
    private PlayerStatistics statistics = new PlayerStatistics();
    
    public Player() {}
    
    public Player(String firstName, String lastName, String position, Integer age) {
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
    
    public Team getTeam() {
        return team;
    }
    
    public void setTeam(Team team) {
        this.team = team;
    }
    
    public PlayerStatistics getStatistics() {
        return statistics;
    }
    
    public void setStatistics(PlayerStatistics statistics) {
        this.statistics = statistics;
    }
}
