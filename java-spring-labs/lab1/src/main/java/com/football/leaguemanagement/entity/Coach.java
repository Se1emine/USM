package com.football.leaguemanagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "coaches")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private Integer age;

    @Column
    private String nationality;

    @Column
    private Integer experienceYears;

    // One-to-One: Coach -> Team
    @OneToOne(mappedBy = "coach", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Team team;

    public Coach() {}

    public Coach(String name, Integer age, String nationality, Integer experienceYears) {
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
