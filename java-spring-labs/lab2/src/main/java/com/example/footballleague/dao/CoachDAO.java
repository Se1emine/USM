package com.example.footballleague.dao;

import com.example.footballleague.entity.Coach;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CoachDAO extends BaseDAO<Coach, Long> {

    public CoachDAO() {
        super(Coach.class);
    }

    @SuppressWarnings("unchecked")
    public List<Coach> findByNationality(String nationality) {
        return getCurrentSession()
                .createQuery("FROM Coach WHERE nationality = :nationality")
                .setParameter("nationality", nationality)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<Coach> findByExperienceYears(int minYears) {
        return getCurrentSession()
                .createQuery("FROM Coach WHERE experienceYears >= :minYears")
                .setParameter("minYears", minYears)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<Coach> findCoachesWithoutTeam() {
        return getCurrentSession()
                .createQuery("FROM Coach c WHERE c.team IS NULL")
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<Coach> findByFullName(String firstName, String lastName) {
        return getCurrentSession()
                .createQuery("FROM Coach WHERE firstName = :firstName AND lastName = :lastName")
                .setParameter("firstName", firstName)
                .setParameter("lastName", lastName)
                .list();
    }
}
