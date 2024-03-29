package org.example.dao;

import org.example.entity.EntityCity;
import org.example.entity.EntityStore;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class EntityCityDAO extends AbstractHibernateDao<EntityCity>{
    public EntityCityDAO(SessionFactory sessionFactory) {
        super(EntityCity.class, sessionFactory);
    }

    public EntityCity getByName(String name){
        Query<EntityCity> query = getCurrentSession().createQuery("select c from EntityCity c where c.city =: NAME", EntityCity.class);
        query.setParameter("NAME", name);
        query.setMaxResults(1);

        return query.getSingleResult();
    }

    public EntityCity getFirstCity(){
        return getCurrentSession().createQuery("SELECT c FROM EntityCity c", EntityCity.class)
                .setMaxResults(1)
                .uniqueResult();
    }
}
