package org.example.dao;

import org.example.entity.EntityAddress;
import org.hibernate.SessionFactory;

public class EntityAddressDAO extends AbstractHibernateDao<EntityAddress>{
    public EntityAddressDAO(SessionFactory sessionFactory) {
        super(EntityAddress.class, sessionFactory);
    }
}
