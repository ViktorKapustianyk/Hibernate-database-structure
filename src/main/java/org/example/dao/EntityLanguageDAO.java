package org.example.dao;

import org.example.entity.EntityCustomer;
import org.example.entity.EntityLanguage;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class EntityLanguageDAO extends AbstractHibernateDao<EntityLanguage>{
    public EntityLanguageDAO(SessionFactory sessionFactory) {
        super(EntityLanguage.class, sessionFactory);
    }

    public EntityLanguage getAnyLanguage(){
        Query<EntityLanguage> query = getCurrentSession().createQuery("select l from EntityLanguage l where l.id = 1", EntityLanguage.class);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}
