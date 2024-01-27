package org.example.dao;

import org.example.entity.EntityCountry;

public class EntityCountryDAO extends AbstractHibernateDao<EntityCountry>{
    public EntityCountryDAO(MySessionFactory sessionFactory) {
        super(EntityCountry.class, sessionFactory);
    }
}
