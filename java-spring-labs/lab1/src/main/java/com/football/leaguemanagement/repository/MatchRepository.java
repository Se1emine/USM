package com.football.leaguemanagement.repository;

import com.football.leaguemanagement.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    
    List<Match> findByLeagueId(Long leagueId);
    
    List<Match> findByStatus(String status);
    
    List<Match> findByRound(Integer round);
    
    @Query("SELECT m FROM Match m WHERE m.homeTeam.id = :teamId OR m.awayTeam.id = :teamId")
    List<Match> findByTeamId(@Param("teamId") Long teamId);
    
    @Query("SELECT m FROM Match m WHERE m.homeTeam.id = :teamId")
    List<Match> findHomeMatchesByTeamId(@Param("teamId") Long teamId);
    
    @Query("SELECT m FROM Match m WHERE m.awayTeam.id = :teamId")
    List<Match> findAwayMatchesByTeamId(@Param("teamId") Long teamId);
    
    @Query("SELECT m FROM Match m WHERE m.matchDate BETWEEN :startDate AND :endDate ORDER BY m.matchDate")
    List<Match> findByDateRange(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
    
    @Query("SELECT m FROM Match m WHERE m.league.id = :leagueId AND m.round = :round")
    List<Match> findByLeagueAndRound(@Param("leagueId") Long leagueId, @Param("round") Integer round);
    
    @Query("SELECT m FROM Match m WHERE (m.homeTeam.id = :team1Id AND m.awayTeam.id = :team2Id) OR (m.homeTeam.id = :team2Id AND m.awayTeam.id = :team1Id)")
    List<Match> findMatchesBetweenTeams(@Param("team1Id") Long team1Id, @Param("team2Id") Long team2Id);
}
