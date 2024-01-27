package org.example.dao;

import org.example.entity.EntityFilmText;

public class EntityFilmTextDAO extends AbstractHibernateDao<EntityFilmText>{
    public EntityFilmTextDAO(MySessionFactory sessionFactory) {
        super(EntityFilmText.class, sessionFactory);
    }
}
