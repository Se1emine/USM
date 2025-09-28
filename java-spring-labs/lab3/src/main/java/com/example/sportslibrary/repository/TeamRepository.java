package com.example.sportslibrary.repository;

import com.example.sportslibrary.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class TeamRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private final RowMapper<Team> teamRowMapper = new RowMapper<Team>() {
        @Override
        public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
            Team team = new Team();
            team.setId(rs.getLong("id"));
            team.setName(rs.getString("name"));
            team.setCity(rs.getString("city"));
            team.setFoundedYear(rs.getInt("founded_year"));
            return team;
        }
    };
    
    public List<Team> findAll() {
        String sql = "SELECT * FROM team";
        return jdbcTemplate.query(sql, teamRowMapper);
    }
    
    public Optional<Team> findById(Long id) {
        String sql = "SELECT * FROM team WHERE id = ?";
        List<Team> teams = jdbcTemplate.query(sql, teamRowMapper, id);
        return teams.isEmpty() ? Optional.empty() : Optional.of(teams.get(0));
    }
    
    public List<Team> findByLeagueId(Long leagueId) {
        String sql = "SELECT * FROM team WHERE league_id = ?";
        return jdbcTemplate.query(sql, teamRowMapper, leagueId);
    }
    
    public Optional<Team> findByCoachId(Long coachId) {
        String sql = "SELECT * FROM team WHERE coach_id = ?";
        List<Team> teams = jdbcTemplate.query(sql, teamRowMapper, coachId);
        return teams.isEmpty() ? Optional.empty() : Optional.of(teams.get(0));
    }
    
    public Team save(Team team) {
        if (team.getId() == null) {
            return insert(team);
        } else {
            return update(team);
        }
    }
    
    private Team insert(Team team) {
        String sql = "INSERT INTO team (name, city, founded_year, coach_id, league_id) VALUES (?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, team.getName());
            ps.setString(2, team.getCity());
            ps.setInt(3, team.getFoundedYear());
            ps.setObject(4, team.getCoach() != null ? team.getCoach().getId() : null);
            ps.setLong(5, team.getLeague().getId());
            return ps;
        }, keyHolder);
        
        team.setId(keyHolder.getKey().longValue());
        return team;
    }
    
    private Team update(Team team) {
        String sql = "UPDATE team SET name = ?, city = ?, founded_year = ?, coach_id = ?, league_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, team.getName(), team.getCity(), team.getFoundedYear(),
                           team.getCoach() != null ? team.getCoach().getId() : null,
                           team.getLeague().getId(), team.getId());
        return team;
    }
    
    public void deleteById(Long id) {
        String sql = "DELETE FROM team WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
    
    public boolean existsById(Long id) {
        String sql = "SELECT COUNT(*) FROM team WHERE id = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return count != null && count > 0;
    }
    
    // Helper methods for getting related data
    public Long getCoachIdByTeamId(Long teamId) {
        String sql = "SELECT coach_id FROM team WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, Long.class, teamId);
    }
    
    public Long getLeagueIdByTeamId(Long teamId) {
        String sql = "SELECT league_id FROM team WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, Long.class, teamId);
    }
}
