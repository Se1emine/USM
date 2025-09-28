package com.example.sportslibrary.repository;

import com.example.sportslibrary.entity.Player;
import com.example.sportslibrary.entity.PlayerStatistics;
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
public class PlayerRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private final RowMapper<Player> playerRowMapper = new RowMapper<Player>() {
        @Override
        public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
            Player player = new Player();
            player.setId(rs.getLong("id"));
            player.setFirstName(rs.getString("first_name"));
            player.setLastName(rs.getString("last_name"));
            player.setPosition(rs.getString("position"));
            player.setAge(rs.getInt("age"));
            
            // Map embedded statistics
            PlayerStatistics statistics = new PlayerStatistics();
            statistics.setGoals(rs.getInt("goals"));
            statistics.setAssists(rs.getInt("assists"));
            statistics.setMatchesPlayed(rs.getInt("matches_played"));
            player.setStatistics(statistics);
            
            return player;
        }
    };
    
    public List<Player> findAll() {
        String sql = "SELECT * FROM player";
        return jdbcTemplate.query(sql, playerRowMapper);
    }
    
    public Optional<Player> findById(Long id) {
        String sql = "SELECT * FROM player WHERE id = ?";
        List<Player> players = jdbcTemplate.query(sql, playerRowMapper, id);
        return players.isEmpty() ? Optional.empty() : Optional.of(players.get(0));
    }
    
    public List<Player> findByTeamId(Long teamId) {
        String sql = "SELECT * FROM player WHERE team_id = ?";
        return jdbcTemplate.query(sql, playerRowMapper, teamId);
    }
    
    public Player save(Player player) {
        if (player.getId() == null) {
            return insert(player);
        } else {
            return update(player);
        }
    }
    
    private Player insert(Player player) {
        String sql = "INSERT INTO player (first_name, last_name, position, age, team_id, goals, assists, matches_played) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, player.getFirstName());
            ps.setString(2, player.getLastName());
            ps.setString(3, player.getPosition());
            ps.setInt(4, player.getAge());
            ps.setLong(5, player.getTeam().getId());
            ps.setInt(6, player.getStatistics().getGoals());
            ps.setInt(7, player.getStatistics().getAssists());
            ps.setInt(8, player.getStatistics().getMatchesPlayed());
            return ps;
        }, keyHolder);
        
        player.setId(keyHolder.getKey().longValue());
        return player;
    }
    
    private Player update(Player player) {
        String sql = "UPDATE player SET first_name = ?, last_name = ?, position = ?, age = ?, team_id = ?, goals = ?, assists = ?, matches_played = ? WHERE id = ?";
        jdbcTemplate.update(sql, player.getFirstName(), player.getLastName(), player.getPosition(),
                           player.getAge(), player.getTeam().getId(),
                           player.getStatistics().getGoals(), player.getStatistics().getAssists(),
                           player.getStatistics().getMatchesPlayed(), player.getId());
        return player;
    }
    
    public void deleteById(Long id) {
        String sql = "DELETE FROM player WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
    
    public boolean existsById(Long id) {
        String sql = "SELECT COUNT(*) FROM player WHERE id = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return count != null && count > 0;
    }
    
    public Long getTeamIdByPlayerId(Long playerId) {
        String sql = "SELECT team_id FROM player WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, Long.class, playerId);
    }
}
