package org.example.dao;

import org.example.entity.EntityCustomer;
import org.hibernate.SessionFactory;

public class EntityCustomerDAO extends AbstractHibernateDao<EntityCustomer>{
    public EntityCustomerDAO(SessionFactory sessionFactory) {
        super(EntityCustomer.class, sessionFactory);
    }
}
