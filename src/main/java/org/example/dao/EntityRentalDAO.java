package org.example.dao;

import org.example.entity.EntityRental;
import org.hibernate.SessionFactory;

public class EntityRentalDAO extends AbstractHibernateDao<EntityRental>{
    public EntityRentalDAO(SessionFactory sessionFactory) {
        super(EntityRental.class, sessionFactory);
    }
}
