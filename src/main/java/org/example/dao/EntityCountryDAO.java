package org.example.dao;

import org.example.entity.EntityCountry;
import org.hibernate.SessionFactory;

public class EntityCountryDAO extends AbstractHibernateDao<EntityCountry>{
    public EntityCountryDAO(SessionFactory sessionFactory) {
        super(EntityCountry.class, sessionFactory);
    }
}
