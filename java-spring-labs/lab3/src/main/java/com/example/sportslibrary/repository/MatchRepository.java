package com.example.sportslibrary.repository;

import com.example.sportslibrary.entity.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class MatchRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private final RowMapper<Match> matchRowMapper = new RowMapper<Match>() {
        @Override
        public Match mapRow(ResultSet rs, int rowNum) throws SQLException {
            Match match = new Match();
            match.setId(rs.getLong("id"));
            match.setMatchDate(rs.getDate("match_date").toLocalDate());
            match.setHomeTeamScore(rs.getInt("home_team_score"));
            match.setAwayTeamScore(rs.getInt("away_team_score"));
            match.setStatus(rs.getString("status"));
            return match;
        }
    };
    
    public List<Match> findAll() {
        String sql = "SELECT * FROM match";
        return jdbcTemplate.query(sql, matchRowMapper);
    }
    
    public Optional<Match> findById(Long id) {
        String sql = "SELECT * FROM match WHERE id = ?";
        List<Match> matches = jdbcTemplate.query(sql, matchRowMapper, id);
        return matches.isEmpty() ? Optional.empty() : Optional.of(matches.get(0));
    }
    
    public List<Match> findByLeagueId(Long leagueId) {
        String sql = "SELECT * FROM match WHERE league_id = ?";
        return jdbcTemplate.query(sql, matchRowMapper, leagueId);
    }
    
    public List<Match> findByTeamId(Long teamId) {
        String sql = "SELECT * FROM match WHERE home_team_id = ? OR away_team_id = ?";
        return jdbcTemplate.query(sql, matchRowMapper, teamId, teamId);
    }
    
    public List<Match> findByHomeTeamId(Long homeTeamId) {
        String sql = "SELECT * FROM match WHERE home_team_id = ?";
        return jdbcTemplate.query(sql, matchRowMapper, homeTeamId);
    }
    
    public List<Match> findByAwayTeamId(Long awayTeamId) {
        String sql = "SELECT * FROM match WHERE away_team_id = ?";
        return jdbcTemplate.query(sql, matchRowMapper, awayTeamId);
    }
    
    public Match save(Match match) {
        if (match.getId() == null) {
            return insert(match);
        } else {
            return update(match);
        }
    }
    
    private Match insert(Match match) {
        String sql = "INSERT INTO match (match_date, home_team_score, away_team_score, status, home_team_id, away_team_id, league_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(match.getMatchDate()));
            ps.setInt(2, match.getHomeTeamScore());
            ps.setInt(3, match.getAwayTeamScore());
            ps.setString(4, match.getStatus());
            ps.setLong(5, match.getHomeTeam().getId());
            ps.setLong(6, match.getAwayTeam().getId());
            ps.setLong(7, match.getLeague().getId());
            return ps;
        }, keyHolder);
        
        match.setId(keyHolder.getKey().longValue());
        return match;
    }
    
    private Match update(Match match) {
        String sql = "UPDATE match SET match_date = ?, home_team_score = ?, away_team_score = ?, status = ?, home_team_id = ?, away_team_id = ?, league_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, Date.valueOf(match.getMatchDate()), match.getHomeTeamScore(),
                           match.getAwayTeamScore(), match.getStatus(),
                           match.getHomeTeam().getId(), match.getAwayTeam().getId(),
                           match.getLeague().getId(), match.getId());
        return match;
    }
    
    public void deleteById(Long id) {
        String sql = "DELETE FROM match WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
    
    public boolean existsById(Long id) {
        String sql = "SELECT COUNT(*) FROM match WHERE id = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return count != null && count > 0;
    }
    
    // Helper methods for getting related data
    public Long getHomeTeamIdByMatchId(Long matchId) {
        String sql = "SELECT home_team_id FROM match WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, Long.class, matchId);
    }
    
    public Long getAwayTeamIdByMatchId(Long matchId) {
        String sql = "SELECT away_team_id FROM match WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, Long.class, matchId);
    }
    
    public Long getLeagueIdByMatchId(Long matchId) {
        String sql = "SELECT league_id FROM match WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, Long.class, matchId);
    }
}
