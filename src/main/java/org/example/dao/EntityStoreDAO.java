package org.example.dao;

import org.example.entity.EntityCity;
import org.example.entity.EntityLanguage;
import org.example.entity.EntityStore;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class EntityStoreDAO extends AbstractHibernateDao<EntityStore>{
    public EntityStoreDAO(SessionFactory sessionFactory) {
        super(EntityStore.class, sessionFactory);
    }
    public EntityStore getFirstStore(){
        return getCurrentSession().createQuery("SELECT s FROM EntityStore s", EntityStore.class)
                .setMaxResults(1)
                .uniqueResult();
    }
}
