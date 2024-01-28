package org.example.dao;

import org.example.entity.EntityCategory;
import org.hibernate.SessionFactory;

public class EntityCategoryDAO extends AbstractHibernateDao<EntityCategory>{
    public EntityCategoryDAO(SessionFactory sessionFactory) {
        super(EntityCategory.class, sessionFactory);
    }
}
