package com.example.footballleague.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "matches")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"homeTeam", "awayTeam", "league"})
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_team_id", nullable = false)
    private Team homeTeam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "away_team_id", nullable = false)
    private Team awayTeam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "league_id")
    private League league;

    @Column(nullable = false)
    private LocalDateTime matchDate;

    private int homeTeamScore;

    private int awayTeamScore;

    @Enumerated(EnumType.STRING)
    private MatchStatus status;

    private String venue;

    public enum MatchStatus {
        SCHEDULED, IN_PROGRESS, FINISHED, CANCELLED, POSTPONED
    }
}
