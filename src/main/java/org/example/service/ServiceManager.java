package org.example.service;

import lombok.Data;
import org.example.dao.*;
import org.example.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDateTime;

@Data
public class ServiceManager {
    private final SessionFactory sessionFactory;
    private final EntityActorDAO entityActorDAO;
    private final EntityAddressDAO entityAddressDAO;
    private final EntityCategoryDAO entityCategoryDAO;
    private final EntityCityDAO entityCityDAO;
    private final EntityCountryDAO entityCountryDAO;
    private final EntityCustomerDAO entityCustomerDAO;
    private final EntityFilmDAO entityFilmDAO;
    private final EntityFilmTextDAO entityFilmTextDAO;
    private final EntityInventoryDAO entityInventoryDAO;
    private final EntityLanguageDAO entityLanguageDAO;
    private final EntityPaymentDAO entityPaymentDAO;
    private final EntityRentalDAO entityRentalDAO;
    private final EntityStaffDAO entityStaffDAO;
    private final EntityStoreDAO entityStoreDAO;

    public ServiceManager(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.entityActorDAO = new EntityActorDAO(sessionFactory);
        this.entityAddressDAO = new EntityAddressDAO(sessionFactory);
        this.entityCategoryDAO = new EntityCategoryDAO(sessionFactory);
        this.entityCityDAO = new EntityCityDAO(sessionFactory);
        this.entityCountryDAO = new EntityCountryDAO(sessionFactory);
        this.entityCustomerDAO = new EntityCustomerDAO(sessionFactory);
        this.entityFilmDAO = new EntityFilmDAO(sessionFactory);
        this.entityFilmTextDAO = new EntityFilmTextDAO(sessionFactory);
        this.entityInventoryDAO = new EntityInventoryDAO(sessionFactory);
        this.entityLanguageDAO = new EntityLanguageDAO(sessionFactory);
        this.entityPaymentDAO = new EntityPaymentDAO(sessionFactory);
        this.entityRentalDAO = new EntityRentalDAO(sessionFactory);
        this.entityStaffDAO = new EntityStaffDAO(sessionFactory);
        this.entityStoreDAO = new EntityStoreDAO(sessionFactory);
    }

    public EntityCustomer createCustomerWithDependencies() {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();

            EntityStore store = entityStoreDAO.getItems(0, 1).get(0);
            EntityCity city = entityCityDAO.getByName("Alvorada");

            EntityAddress address = new EntityAddress();
            address.setAddress("Indept str, 48");
            address.setPhone("999-111-555");
            address.setCity(city);
            address.setDistrict("West");

            entityAddressDAO.create(address);

            EntityCustomer customer = new EntityCustomer();
            customer.setIsActive(true);
            customer.setAddress(address);
            customer.setStore(store);
            customer.setEmail("test@gmail.com");
            customer.setFirstName("Vitya");
            customer.setLastName("Kap");

            entityCustomerDAO.create(customer);

            transaction.commit();

            return customer;
        }
    }

    public void customerReturnInventoryToStore(){
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();

            EntityRental rental = entityRentalDAO.getAnyUnrenturnedRantal();
            rental.setRentalDate(LocalDateTime.now());

            entityRentalDAO.create(rental);

            transaction.commit();
        }
    }
}
