package org.example.service;

import lombok.Data;
import org.example.dao.*;
import org.example.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.math.BigDecimal;
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
            rental.setReturnDate(LocalDateTime.now());

            entityRentalDAO.create(rental);

            transaction.commit();
        }
    }

    public void customerRentInventory(){
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            EntityFilm film = entityFilmDAO.getFirstAvailableFilmForRent();

            EntityStore store = entityStoreDAO.getItems(0, 1).get(0);
            EntityCustomer customer = entityCustomerDAO.getAnyCustomer();

            EntityInventory inventory = new EntityInventory();
            inventory.setFilm(film);
            inventory.setStore(store);
            entityInventoryDAO.create(inventory);

            EntityStaff staff = store.getStaff();

            EntityRental rental = new EntityRental();
            rental.setRentalDate(LocalDateTime.now());
            rental.setCustomer(customer);
            rental.setInventory(inventory);
            rental.setStaff(staff);
            entityRentalDAO.create(rental);

            EntityPayment payment = new EntityPayment();
            payment.setCustomer(customer);
            payment.setStaff(staff);
            payment.setPaymentDate(LocalDateTime.now());
            payment.setRental(rental);
            payment.setAmount(BigDecimal.valueOf(55,77));
            entityPaymentDAO.create(payment);

            session.getTransaction().commit();
        }
    }
}