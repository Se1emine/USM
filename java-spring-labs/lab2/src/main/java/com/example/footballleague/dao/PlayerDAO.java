package com.example.footballleague.dao;

import com.example.footballleague.entity.Player;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PlayerDAO extends BaseDAO<Player, Long> {

    public PlayerDAO() {
        super(Player.class);
    }

    @SuppressWarnings("unchecked")
    public List<Player> findByTeamId(Long teamId) {
        return getCurrentSession()
                .createQuery("FROM Player WHERE team.id = :teamId")
                .setParameter("teamId", teamId)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<Player> findByPosition(Player.Position position) {
        return getCurrentSession()
                .createQuery("FROM Player WHERE position = :position")
                .setParameter("position", position)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<Player> findByNationality(String nationality) {
        return getCurrentSession()
                .createQuery("FROM Player WHERE nationality = :nationality")
                .setParameter("nationality", nationality)
                .list();
    }

    public Player findByJerseyNumberAndTeam(int jerseyNumber, Long teamId) {
        List<Player> players = getCurrentSession()
                .createQuery("FROM Player WHERE jerseyNumber = :jerseyNumber AND team.id = :teamId")
                .setParameter("jerseyNumber", jerseyNumber)
                .setParameter("teamId", teamId)
                .list();
        return players.isEmpty() ? null : players.get(0);
    }

    @SuppressWarnings("unchecked")
    public List<Player> findTopScorers(int limit) {
        return getCurrentSession()
                .createQuery("FROM Player p ORDER BY p.statistics.goals DESC")
                .setMaxResults(limit)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<Player> findByFullName(String firstName, String lastName) {
        return getCurrentSession()
                .createQuery("FROM Player WHERE firstName = :firstName AND lastName = :lastName")
                .setParameter("firstName", firstName)
                .setParameter("lastName", lastName)
                .list();
    }
}
