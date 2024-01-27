package org.example.dao;

import org.example.entity.EntityLanguage;

public class EntityLanguageDAO extends AbstractHibernateDao<EntityLanguage>{
    public EntityLanguageDAO(MySessionFactory sessionFactory) {
        super(EntityLanguage.class, sessionFactory);
    }
}
