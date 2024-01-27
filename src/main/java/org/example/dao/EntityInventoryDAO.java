package org.example.dao;

import org.example.entity.EntityInventory;

public class EntityInventoryDAO extends AbstractHibernateDao<EntityInventory>{
    public EntityInventoryDAO(MySessionFactory sessionFactory) {
        super(EntityInventory.class, sessionFactory);
    }
}
