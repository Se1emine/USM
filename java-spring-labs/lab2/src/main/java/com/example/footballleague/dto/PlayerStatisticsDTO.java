package com.example.footballleague.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerStatisticsDTO {
    private int goals;
    private int assists;
    private int matchesPlayed;
    private int yellowCards;
    private int redCards;
}
