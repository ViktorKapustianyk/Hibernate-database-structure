package org.example.dao;

import org.example.entity.EntityFilmText;
import org.hibernate.SessionFactory;

public class EntityFilmTextDAO extends AbstractHibernateDao<EntityFilmText>{
    public EntityFilmTextDAO(SessionFactory sessionFactory) {
        super(EntityFilmText.class, sessionFactory);
    }
}
