package com.football.leaguemanagement.repository;

import com.football.leaguemanagement.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    
    List<Player> findByTeamId(Long teamId);
    
    List<Player> findByPosition(String position);
    
    List<Player> findByNationality(String nationality);
    
    Optional<Player> findByTeamIdAndJerseyNumber(Long teamId, Integer jerseyNumber);
    
    @Query("SELECT p FROM Player p WHERE p.team.id = :teamId AND p.position = :position")
    List<Player> findByTeamAndPosition(@Param("teamId") Long teamId, @Param("position") String position);
    
    @Query("SELECT p FROM Player p WHERE p.statistics.goals >= :minGoals ORDER BY p.statistics.goals DESC")
    List<Player> findTopScorers(@Param("minGoals") int minGoals);
    
    @Query("SELECT p FROM Player p WHERE p.age BETWEEN :minAge AND :maxAge")
    List<Player> findByAgeRange(@Param("minAge") int minAge, @Param("maxAge") int maxAge);
    
    @Query("SELECT COUNT(p) FROM Player p WHERE p.team.id = :teamId")
    long countByTeamId(@Param("teamId") Long teamId);
    
    boolean existsByTeamIdAndJerseyNumber(Long teamId, Integer jerseyNumber);
}
