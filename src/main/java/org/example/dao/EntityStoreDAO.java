package org.example.dao;

import org.example.entity.EntityStore;
import org.hibernate.SessionFactory;

public class EntityStoreDAO extends AbstractHibernateDao<EntityStore>{
    public EntityStoreDAO(SessionFactory sessionFactory) {
        super(EntityStore.class, sessionFactory);
    }
}
