package org.example.dao;

import org.example.entity.EntityLanguage;
import org.hibernate.SessionFactory;

public class EntityLanguageDAO extends AbstractHibernateDao<EntityLanguage>{
    public EntityLanguageDAO(SessionFactory sessionFactory) {
        super(EntityLanguage.class, sessionFactory);
    }
}
