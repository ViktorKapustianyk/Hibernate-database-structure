package org.example.dao;

import org.example.entity.EntityStore;

public class EntityStoreDAO extends AbstractHibernateDao<EntityStore>{
    public EntityStoreDAO(MySessionFactory sessionFactory) {
        super(EntityStore.class, sessionFactory);
    }
}
