package org.example.dao;

import org.example.entity.EntityCity;

public class EntityCityDAO extends AbstractHibernateDao<EntityCity>{
    public EntityCityDAO(MySessionFactory sessionFactory) {
        super(EntityCity.class, sessionFactory);
    }
}
