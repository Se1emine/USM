package com.football.leaguemanagement.repository;

import com.football.leaguemanagement.entity.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeagueRepository extends JpaRepository<League, Long> {
    
    Optional<League> findByName(String name);
    
    List<League> findByCountry(String country);
    
    List<League> findBySeason(Integer season);
    
    @Query("SELECT l FROM League l WHERE l.country = :country AND l.season = :season")
    List<League> findByCountryAndSeason(@Param("country") String country, @Param("season") Integer season);
    
    boolean existsByName(String name);
}
