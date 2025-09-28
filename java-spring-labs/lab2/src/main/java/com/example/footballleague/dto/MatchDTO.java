package com.example.footballleague.dto;

import com.example.footballleague.entity.Match;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchDTO {
    private Long id;
    
    @NotNull(message = "Home team is required")
    private Long homeTeamId;
    
    @NotNull(message = "Away team is required")
    private Long awayTeamId;
    
    private Long leagueId;
    
    @NotNull(message = "Match date is required")
    private LocalDateTime matchDate;
    
    private int homeTeamScore;
    private int awayTeamScore;
    private Match.MatchStatus status;
    private String venue;
}
