package org.example.dao;

import org.example.entity.EntityActor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class EntityActorDAO extends AbstractHibernateDao<EntityActor>{
    public EntityActorDAO(SessionFactory sessionFactory) {
        super(EntityActor.class, sessionFactory);
    }
}
