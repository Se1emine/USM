package com.football.leaguemanagement.dto;

public class PlayerStatisticsDTO {
    private int goals;
    private int assists;
    private int yellowCards;
    private int redCards;
    private int matchesPlayed;

    public PlayerStatisticsDTO() {}

    public PlayerStatisticsDTO(int goals, int assists, int yellowCards, int redCards, int matchesPlayed) {
        this.goals = goals;
        this.assists = assists;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.matchesPlayed = matchesPlayed;
    }

    // Getters and Setters
    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    public int getRedCards() {
        return redCards;
    }

    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }
}
