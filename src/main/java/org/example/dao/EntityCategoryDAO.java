package org.example.dao;

import org.example.entity.EntityCategory;

public class EntityCategoryDAO extends AbstractHibernateDao<EntityCategory>{
    public EntityCategoryDAO(MySessionFactory sessionFactory) {
        super(EntityCategory.class, sessionFactory);
    }
}
