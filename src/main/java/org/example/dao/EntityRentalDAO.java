package org.example.dao;

import org.example.entity.EntityRental;

public class EntityRentalDAO extends AbstractHibernateDao<EntityRental>{
    public EntityRentalDAO(MySessionFactory sessionFactory) {
        super(EntityRental.class, sessionFactory);
    }
}
