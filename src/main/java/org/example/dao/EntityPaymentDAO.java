package org.example.dao;

import org.example.entity.EntityPayment;

public class EntityPaymentDAO extends AbstractHibernateDao<EntityPayment>{
    public EntityPaymentDAO(MySessionFactory sessionFactory) {
        super(EntityPayment.class, sessionFactory);
    }
}
