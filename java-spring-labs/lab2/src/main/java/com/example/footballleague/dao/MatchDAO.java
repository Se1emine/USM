package com.example.footballleague.dao;

import com.example.footballleague.entity.Match;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public class MatchDAO extends BaseDAO<Match, Long> {

    public MatchDAO() {
        super(Match.class);
    }

    @SuppressWarnings("unchecked")
    public List<Match> findByTeamId(Long teamId) {
        return getCurrentSession()
                .createQuery("FROM Match WHERE homeTeam.id = :teamId OR awayTeam.id = :teamId")
                .setParameter("teamId", teamId)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<Match> findByLeagueId(Long leagueId) {
        return getCurrentSession()
                .createQuery("FROM Match WHERE league.id = :leagueId")
                .setParameter("leagueId", leagueId)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<Match> findByStatus(Match.MatchStatus status) {
        return getCurrentSession()
                .createQuery("FROM Match WHERE status = :status")
                .setParameter("status", status)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<Match> findByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return getCurrentSession()
                .createQuery("FROM Match WHERE matchDate BETWEEN :startDate AND :endDate")
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<Match> findUpcomingMatches() {
        return getCurrentSession()
                .createQuery("FROM Match WHERE matchDate > :now AND status = :status ORDER BY matchDate ASC")
                .setParameter("now", LocalDateTime.now())
                .setParameter("status", Match.MatchStatus.SCHEDULED)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<Match> findFinishedMatches() {
        return getCurrentSession()
                .createQuery("FROM Match WHERE status = :status ORDER BY matchDate DESC")
                .setParameter("status", Match.MatchStatus.FINISHED)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<Match> findMatchesBetweenTeams(Long homeTeamId, Long awayTeamId) {
        return getCurrentSession()
                .createQuery("FROM Match WHERE (homeTeam.id = :homeTeamId AND awayTeam.id = :awayTeamId) OR (homeTeam.id = :awayTeamId AND awayTeam.id = :homeTeamId)")
                .setParameter("homeTeamId", homeTeamId)
                .setParameter("awayTeamId", awayTeamId)
                .list();
    }
}
