package org.example.dao;

import org.example.entity.EntityCustomer;
import org.example.entity.EntityFilm;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class EntityCustomerDAO extends AbstractHibernateDao<EntityCustomer>{
    public EntityCustomerDAO(SessionFactory sessionFactory) {
        super(EntityCustomer.class, sessionFactory);
    }

    public EntityCustomer getAnyCustomer() {
        Query<EntityCustomer> query = getCurrentSession().createQuery("select c from EntityCustomer c where c.firstName like '%vitya%'", EntityCustomer.class);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}
