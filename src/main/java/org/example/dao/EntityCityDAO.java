package org.example.dao;

import org.example.entity.EntityCity;
import org.hibernate.SessionFactory;

public class EntityCityDAO extends AbstractHibernateDao<EntityCity>{
    public EntityCityDAO(SessionFactory sessionFactory) {
        super(EntityCity.class, sessionFactory);
    }
}
