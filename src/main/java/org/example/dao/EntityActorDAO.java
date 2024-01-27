package org.example.dao;

import org.example.entity.EntityActor;

public class EntityActorDAO extends AbstractHibernateDao<EntityActor>{
    public EntityActorDAO(MySessionFactory sessionFactory) {
        super(EntityActor.class, sessionFactory);
    }
}
