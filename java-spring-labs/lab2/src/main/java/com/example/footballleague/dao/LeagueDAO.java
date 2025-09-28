package com.example.footballleague.dao;

import com.example.footballleague.entity.League;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class LeagueDAO extends BaseDAO<League, Long> {

    public LeagueDAO() {
        super(League.class);
    }

    public League findByName(String name) {
        List<League> leagues = findByProperty("name", name);
        return leagues.isEmpty() ? null : leagues.get(0);
    }

    @SuppressWarnings("unchecked")
    public List<League> findByCountry(String country) {
        return getCurrentSession()
                .createQuery("FROM League WHERE country = :country")
                .setParameter("country", country)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<League> findLeaguesWithTeams() {
        return getCurrentSession()
                .createQuery("SELECT DISTINCT l FROM League l LEFT JOIN FETCH l.teams")
                .list();
    }
}
