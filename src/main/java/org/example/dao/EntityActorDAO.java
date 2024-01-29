package org.example.dao;

import org.example.entity.EntityActor;
import org.example.entity.EntityCategory;
import org.example.entity.EntityLanguage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EntityActorDAO extends AbstractHibernateDao<EntityActor>{
    public EntityActorDAO(SessionFactory sessionFactory) {
        super(EntityActor.class, sessionFactory);
    }

    public Set<EntityActor> getFirstFourActors() {
        List<EntityActor> actors = getItems(0, 4);
        return new HashSet<>(actors);
    }
}
