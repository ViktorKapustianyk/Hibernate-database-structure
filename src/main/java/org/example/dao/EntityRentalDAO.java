package org.example.dao;

import org.example.entity.EntityRental;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class EntityRentalDAO extends AbstractHibernateDao<EntityRental>{
    public EntityRentalDAO(SessionFactory sessionFactory) {
        super(EntityRental.class, sessionFactory);
    }

    public EntityRental getAnyUnrenturnedRantal(){
        Query<EntityRental> query = getCurrentSession().createQuery("select r from EntityRental r where r.returnDate is null", EntityRental.class);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}
