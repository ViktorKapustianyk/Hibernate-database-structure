package org.example.service;

import org.example.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySessionFactory {
    private static MySessionFactory instance;
    private final SessionFactory sessionFactory;
    private MySessionFactory() {

        sessionFactory = new Configuration()
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
                .configure("hibernate_mysql.cfg.xml")
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        if (instance == null) {
            instance = new MySessionFactory();
        }
        return instance.sessionFactory;
    }
}
