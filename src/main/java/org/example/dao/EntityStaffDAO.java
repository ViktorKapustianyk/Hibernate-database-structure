package org.example.dao;

import org.example.entity.EntityStaff;
import org.hibernate.SessionFactory;

public class EntityStaffDAO extends AbstractHibernateDao<EntityStaff>{
    public EntityStaffDAO(SessionFactory sessionFactory) {
        super(EntityStaff.class, sessionFactory);
    }
}
