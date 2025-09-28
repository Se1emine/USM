package com.example.footballleague.dao;

import com.example.footballleague.entity.Team;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TeamDAO extends BaseDAO<Team, Long> {

    public TeamDAO() {
        super(Team.class);
    }

    public Team findByName(String name) {
        List<Team> teams = findByProperty("name", name);
        return teams.isEmpty() ? null : teams.get(0);
    }

    @SuppressWarnings("unchecked")
    public List<Team> findByCity(String city) {
        return getCurrentSession()
                .createQuery("FROM Team WHERE city = :city")
                .setParameter("city", city)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<Team> findByLeagueId(Long leagueId) {
        return getCurrentSession()
                .createQuery("FROM Team WHERE league.id = :leagueId")
                .setParameter("leagueId", leagueId)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<Team> findTeamsWithPlayers() {
        return getCurrentSession()
                .createQuery("SELECT DISTINCT t FROM Team t LEFT JOIN FETCH t.players")
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<Team> findTeamsWithCoach() {
        return getCurrentSession()
                .createQuery("SELECT t FROM Team t WHERE t.coach IS NOT NULL")
                .list();
    }
}
