package com.football.leaguemanagement.repository;

import com.football.leaguemanagement.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {
    
    Optional<Coach> findByName(String name);
    
    List<Coach> findByNationality(String nationality);
    
    @Query("SELECT c FROM Coach c WHERE c.experienceYears >= :minExperience ORDER BY c.experienceYears DESC")
    List<Coach> findByMinimumExperience(@Param("minExperience") int minExperience);
    
    @Query("SELECT c FROM Coach c WHERE c.age BETWEEN :minAge AND :maxAge")
    List<Coach> findByAgeRange(@Param("minAge") int minAge, @Param("maxAge") int maxAge);
    
    @Query("SELECT c FROM Coach c WHERE c.team IS NULL")
    List<Coach> findAvailableCoaches();
    
    @Query("SELECT c FROM Coach c WHERE c.team IS NOT NULL")
    List<Coach> findCoachesWithTeams();
}
