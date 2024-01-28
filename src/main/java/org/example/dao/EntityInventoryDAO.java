package org.example.dao;

import org.example.entity.EntityInventory;
import org.hibernate.SessionFactory;

public class EntityInventoryDAO extends AbstractHibernateDao<EntityInventory>{
    public EntityInventoryDAO(SessionFactory sessionFactory) {
        super(EntityInventory.class, sessionFactory);
    }
}
