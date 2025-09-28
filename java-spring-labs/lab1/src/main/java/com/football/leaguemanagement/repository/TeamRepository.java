package com.football.leaguemanagement.repository;

import com.football.leaguemanagement.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    
    Optional<Team> findByName(String name);
    
    List<Team> findByCity(String city);
    
    List<Team> findByLeagueId(Long leagueId);
    
    @Query("SELECT t FROM Team t WHERE t.league.id = :leagueId")
    List<Team> findTeamsByLeague(@Param("leagueId") Long leagueId);
    
    @Query("SELECT t FROM Team t WHERE t.coach.id = :coachId")
    Optional<Team> findByCoachId(@Param("coachId") Long coachId);
    
    boolean existsByName(String name);
    
    @Query("SELECT COUNT(t) FROM Team t WHERE t.league.id = :leagueId")
    long countByLeagueId(@Param("leagueId") Long leagueId);
}
