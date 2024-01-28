package org.example.dao;

import org.example.entity.EntityFilm;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class EntityFilmDAO extends AbstractHibernateDao<EntityFilm>{
    public EntityFilmDAO(SessionFactory sessionFactory) {
        super(EntityFilm.class, sessionFactory);
    }

    public EntityFilm getFirstAvailableFilmForRent() {
        Query<EntityFilm> query = getCurrentSession().createQuery("select f from EntityFilm f where f.id not in (select distinct film.id from EntityInventory)", EntityFilm.class);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}
