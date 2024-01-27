package org.example.dao;

import org.example.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class MySessionFactory {
    private static MySessionFactory instance;
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

        entityActorDAO = new EntityActorDAO(this);
        entityAddressDAO = new EntityAddressDAO(this);
        entityCategoryDAO = new EntityCategoryDAO(this);
        entityCityDAO = new EntityCityDAO(this);
        entityCountryDAO = new EntityCountryDAO(this);
        entityCustomerDAO = new EntityCustomerDAO(this);
        entityFilmDAO = new EntityFilmDAO(this);
        entityFilmTextDAO = new EntityFilmTextDAO(this);
        entityInventoryDAO = new EntityInventoryDAO(this);
        entityLanguageDAO = new EntityLanguageDAO(this);
        entityPaymentDAO = new EntityPaymentDAO(this);
        entityRentalDAO = new EntityRentalDAO(this);
        entityStaffDAO = new EntityStaffDAO(this);
        entityStoreDAO = new EntityStoreDAO(this);
    }

    public static SessionFactory getSessionFactory() {
        if (instance == null) {
            instance = new MySessionFactory();
        }
        return instance.sessionFactory;
    }
}
