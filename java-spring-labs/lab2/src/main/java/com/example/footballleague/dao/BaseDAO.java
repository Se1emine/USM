package com.example.footballleague.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public abstract class BaseDAO<T, ID extends Serializable> {

    @Autowired
    protected SessionFactory sessionFactory;

    private final Class<T> entityClass;

    protected BaseDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public T save(T entity) {
        getCurrentSession().save(entity);
        return entity;
    }

    public T update(T entity) {
        getCurrentSession().update(entity);
        return entity;
    }

    public T saveOrUpdate(T entity) {
        getCurrentSession().saveOrUpdate(entity);
        return entity;
    }

    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }

    public void deleteById(ID id) {
        T entity = findById(id);
        if (entity != null) {
            delete(entity);
        }
    }

    public T findById(ID id) {
        return getCurrentSession().get(entityClass, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return getCurrentSession()
                .createQuery("FROM " + entityClass.getSimpleName())
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<T> findByProperty(String propertyName, Object value) {
        return getCurrentSession()
                .createQuery("FROM " + entityClass.getSimpleName() + " WHERE " + propertyName + " = :value")
                .setParameter("value", value)
                .list();
    }

    public long count() {
        return (Long) getCurrentSession()
                .createQuery("SELECT COUNT(*) FROM " + entityClass.getSimpleName())
                .uniqueResult();
    }
}
