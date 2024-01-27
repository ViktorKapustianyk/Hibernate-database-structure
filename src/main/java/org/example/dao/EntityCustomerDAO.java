package org.example.dao;

import org.example.entity.EntityCustomer;

public class EntityCustomerDAO extends AbstractHibernateDao<EntityCustomer>{
    public EntityCustomerDAO(MySessionFactory sessionFactory) {
        super(EntityCustomer.class, sessionFactory);
    }
}
