package org.example.dao;

import org.example.entity.EntityFilm;

public class EntityFilmDAO extends AbstractHibernateDao<EntityFilm>{
    public EntityFilmDAO(MySessionFactory sessionFactory) {
        super(EntityFilm.class, sessionFactory);
    }
}
