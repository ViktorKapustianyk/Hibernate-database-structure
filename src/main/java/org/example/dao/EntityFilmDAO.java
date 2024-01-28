package org.example.dao;

import org.example.entity.EntityFilm;
import org.hibernate.SessionFactory;

public class EntityFilmDAO extends AbstractHibernateDao<EntityFilm>{
    public EntityFilmDAO(SessionFactory sessionFactory) {
        super(EntityFilm.class, sessionFactory);
    }
}
