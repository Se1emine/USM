package com.example.sportslibrary.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "coach")
public class Coach {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "First name cannot be blank")
    @Column(name = "first_name", nullable = false)
    private String firstName;
    
    @NotBlank(message = "Last name cannot be blank")
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @Min(value = 0, message = "Experience years cannot be negative")
    @Column(name = "experience_years", nullable = false)
    private Integer experienceYears;
    
    @NotBlank(message = "Nationality cannot be blank")
    @Column(nullable = false)
    private String nationality;
    
    @OneToOne(mappedBy = "coach", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Team team;
    
    public Coach() {}
    
    public Coach(String firstName, String lastName, Integer experienceYears, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.experienceYears = experienceYears;
        this.nationality = nationality;
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
    
    public Integer getExperienceYears() {
        return experienceYears;
    }
    
    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }
    
    public String getNationality() {
        return nationality;
    }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    public Team getTeam() {
        return team;
    }
    
    public void setTeam(Team team) {
        this.team = team;
    }
}
