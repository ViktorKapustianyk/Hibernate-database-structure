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
                .setProperties(properties)
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        if (instance == null) {
            instance = new MySessionFactory();
        }
        return instance.sessionFactory;
    }
}
