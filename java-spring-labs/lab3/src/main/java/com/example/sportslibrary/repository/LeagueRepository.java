package com.example.sportslibrary.repository;

import com.example.sportslibrary.entity.League;
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
public class LeagueRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private final RowMapper<League> leagueRowMapper = new RowMapper<League>() {
        @Override
        public League mapRow(ResultSet rs, int rowNum) throws SQLException {
            League league = new League();
            league.setId(rs.getLong("id"));
            league.setName(rs.getString("name"));
            league.setCountry(rs.getString("country"));
            league.setSeason(rs.getString("season"));
            return league;
        }
    };
    
    public List<League> findAll() {
        String sql = "SELECT * FROM league";
        return jdbcTemplate.query(sql, leagueRowMapper);
    }
    
    public Optional<League> findById(Long id) {
        String sql = "SELECT * FROM league WHERE id = ?";
        List<League> leagues = jdbcTemplate.query(sql, leagueRowMapper, id);
        return leagues.isEmpty() ? Optional.empty() : Optional.of(leagues.get(0));
    }
    
    public League save(League league) {
        if (league.getId() == null) {
            return insert(league);
        } else {
            return update(league);
        }
    }
    
    private League insert(League league) {
        String sql = "INSERT INTO league (name, country, season) VALUES (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, league.getName());
            ps.setString(2, league.getCountry());
            ps.setString(3, league.getSeason());
            return ps;
        }, keyHolder);
        
        league.setId(keyHolder.getKey().longValue());
        return league;
    }
    
    private League update(League league) {
        String sql = "UPDATE league SET name = ?, country = ?, season = ? WHERE id = ?";
        jdbcTemplate.update(sql, league.getName(), league.getCountry(), league.getSeason(), league.getId());
        return league;
    }
    
    public void deleteById(Long id) {
        String sql = "DELETE FROM league WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
    
    public boolean existsById(Long id) {
        String sql = "SELECT COUNT(*) FROM league WHERE id = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return count != null && count > 0;
    }
}
