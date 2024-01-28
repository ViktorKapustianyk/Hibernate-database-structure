package org.example.dao;

import org.example.entity.EntityPayment;
import org.hibernate.SessionFactory;

public class EntityPaymentDAO extends AbstractHibernateDao<EntityPayment>{
    public EntityPaymentDAO(SessionFactory sessionFactory) {
        super(EntityPayment.class, sessionFactory);
    }
}
