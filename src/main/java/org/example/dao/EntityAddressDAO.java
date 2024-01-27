package org.example.dao;

import org.example.entity.EntityAddress;

public class EntityAddressDAO extends AbstractHibernateDao<EntityAddress>{
    public EntityAddressDAO(MySessionFactory sessionFactory) {
        super(EntityAddress.class, sessionFactory);
    }
}
