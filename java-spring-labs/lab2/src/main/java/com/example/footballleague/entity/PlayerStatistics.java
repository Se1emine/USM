package com.example.footballleague.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerStatistics {
    private int goals;
    private int assists;
    private int matchesPlayed;
    private int yellowCards;
    private int redCards;
}
