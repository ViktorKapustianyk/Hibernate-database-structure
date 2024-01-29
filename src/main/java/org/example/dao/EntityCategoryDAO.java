package org.example.dao;

import org.example.entity.EntityCategory;
import org.hibernate.SessionFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EntityCategoryDAO extends AbstractHibernateDao<EntityCategory>{
    public EntityCategoryDAO(SessionFactory sessionFactory) {
        super(EntityCategory.class, sessionFactory);
    }

    public Set<EntityCategory> getFirstFourCategories() {
        List<EntityCategory> categories = getItems(0, 4);
        return new HashSet<>(categories);
    }
}
