package org.example.service;

import lombok.Getter;
import org.example.dao.*;
import org.example.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

@Getter
public class MySessionFactory {
    private static MySessionFactory instance;
    private final SessionFactory sessionFactory;
//    private final EntityActorDAO entityActorDAO;
//    private final EntityAddressDAO entityAddressDAO;
//    private final EntityCategoryDAO entityCategoryDAO;
//    private final EntityCityDAO entityCityDAO;
//    private final EntityCountryDAO entityCountryDAO;
//    private final EntityCustomerDAO entityCustomerDAO;
//    private final EntityFilmDAO entityFilmDAO;
//    private final EntityFilmTextDAO entityFilmTextDAO;
//    private final EntityInventoryDAO entityInventoryDAO;
//    private final EntityLanguageDAO entityLanguageDAO;
//    private final EntityPaymentDAO entityPaymentDAO;
//    private final EntityRentalDAO entityRentalDAO;
//    private final EntityStaffDAO entityStaffDAO;
//    private final EntityStoreDAO entityStoreDAO;

    private MySessionFactory() {
        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/movie");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "root");
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        properties.put(Environment.HBM2DDL_AUTO, "validate");
//
//        properties.put("hibernate.connection.useUnicode", true);
//        properties.put("hibernate.connection.characterEncoding", "UTF-8");
//        properties.put("hibernate.connection.charSet", "UTF-8");

        sessionFactory = new Configuration()
                .setProperties(properties)
                .addAnnotatedClass(EntityActor.class)
                .addAnnotatedClass(EntityAddress.class)
                .addAnnotatedClass(EntityCategory.class)
                .addAnnotatedClass(EntityCity.class)
                .addAnnotatedClass(EntityCountry.class)
                .addAnnotatedClass(EntityCustomer.class)
                .addAnnotatedClass(EntityFilm.class)
                .addAnnotatedClass(EntityFilmText.class)
                .addAnnotatedClass(EntityInventory.class)
                .addAnnotatedClass(EntityLanguage.class)
                .addAnnotatedClass(EntityPayment.class)
                .addAnnotatedClass(EntityRental.class)
                .addAnnotatedClass(EntityStaff.class)
                .addAnnotatedClass(EntityStore.class)
                .buildSessionFactory();

//        entityActorDAO = new EntityActorDAO(sessionFactory);
//        entityAddressDAO = new EntityAddressDAO(sessionFactory);
//        entityCategoryDAO = new EntityCategoryDAO(sessionFactory);
//        entityCityDAO = new EntityCityDAO(sessionFactory);
//        entityCountryDAO = new EntityCountryDAO(sessionFactory);
//        entityCustomerDAO = new EntityCustomerDAO(sessionFactory);
//        entityFilmDAO = new EntityFilmDAO(sessionFactory);
//        entityFilmTextDAO = new EntityFilmTextDAO(sessionFactory);
//        entityInventoryDAO = new EntityInventoryDAO(sessionFactory);
//        entityLanguageDAO = new EntityLanguageDAO(sessionFactory);
//        entityPaymentDAO = new EntityPaymentDAO(sessionFactory);
//        entityRentalDAO = new EntityRentalDAO(sessionFactory);
//        entityStaffDAO = new EntityStaffDAO(sessionFactory);
//        entityStoreDAO = new EntityStoreDAO(sessionFactory);
    }

    public static SessionFactory getSessionFactory() {
        if (instance == null) {
            instance = new MySessionFactory();
        }
        return instance.sessionFactory;
    }

//    public EntityCustomer createCustomerWithDependencies() {
//        try (Session session = MySessionFactory.getSessionFactory().getCurrentSession()) {
//
//            session.beginTransaction();
//            EntityStore store = entityStoreDAO.getItems(0, 1).get(0);
//            EntityCity city = entityCityDAO.getByName("");
//
//            EntityAddress address = new EntityAddress();
//            address.setAddress("Indept str, 48");
//            address.setPhone("999-111-555");
//            address.setCity(city);
//            address.setDistrict("West");
//
//            entityAddressDAO.create(address);
//
//            EntityCustomer customer = new EntityCustomer();
//            customer.setIsActive(true);
//            customer.setAddress(address);
//            customer.setStore(store);
//            customer.setEmail("test@gmail.com");
//            customer.setFirstName("Vitya");
//            customer.setLastName("Kap");
//
//            entityCustomerDAO.create(customer);
//
//            session.getTransaction().commit();
//
//            return customer;
//        }
//    }
}
