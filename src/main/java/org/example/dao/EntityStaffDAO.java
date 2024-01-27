package org.example.dao;

import org.example.entity.EntityStaff;

public class EntityStaffDAO extends AbstractHibernateDao<EntityStaff>{
    public EntityStaffDAO(MySessionFactory sessionFactory) {
        super(EntityStaff.class, sessionFactory);
    }
}
