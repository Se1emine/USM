package com.example.sportslibrary.repository;

import com.example.sportslibrary.entity.Coach;
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
public class CoachRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private final RowMapper<Coach> coachRowMapper = new RowMapper<Coach>() {
        @Override
        public Coach mapRow(ResultSet rs, int rowNum) throws SQLException {
            Coach coach = new Coach();
            coach.setId(rs.getLong("id"));
            coach.setFirstName(rs.getString("first_name"));
            coach.setLastName(rs.getString("last_name"));
            coach.setExperienceYears(rs.getInt("experience_years"));
            coach.setNationality(rs.getString("nationality"));
            return coach;
        }
    };
    
    public List<Coach> findAll() {
        String sql = "SELECT * FROM coach";
        return jdbcTemplate.query(sql, coachRowMapper);
    }
    
    public Optional<Coach> findById(Long id) {
        String sql = "SELECT * FROM coach WHERE id = ?";
        List<Coach> coaches = jdbcTemplate.query(sql, coachRowMapper, id);
        return coaches.isEmpty() ? Optional.empty() : Optional.of(coaches.get(0));
    }
    
    public List<Coach> findAvailableCoaches() {
        String sql = "SELECT c.* FROM coach c LEFT JOIN team t ON c.id = t.coach_id WHERE t.coach_id IS NULL";
        return jdbcTemplate.query(sql, coachRowMapper);
    }
    
    public Coach save(Coach coach) {
        if (coach.getId() == null) {
            return insert(coach);
        } else {
            return update(coach);
        }
    }
    
    private Coach insert(Coach coach) {
        String sql = "INSERT INTO coach (first_name, last_name, experience_years, nationality) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, coach.getFirstName());
            ps.setString(2, coach.getLastName());
            ps.setInt(3, coach.getExperienceYears());
            ps.setString(4, coach.getNationality());
            return ps;
        }, keyHolder);
        
        coach.setId(keyHolder.getKey().longValue());
        return coach;
    }
    
    private Coach update(Coach coach) {
        String sql = "UPDATE coach SET first_name = ?, last_name = ?, experience_years = ?, nationality = ? WHERE id = ?";
        jdbcTemplate.update(sql, coach.getFirstName(), coach.getLastName(), 
                           coach.getExperienceYears(), coach.getNationality(), coach.getId());
        return coach;
    }
    
    public void deleteById(Long id) {
        String sql = "DELETE FROM coach WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
    
    public boolean existsById(Long id) {
        String sql = "SELECT COUNT(*) FROM coach WHERE id = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return count != null && count > 0;
    }
}
