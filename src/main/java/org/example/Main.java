package org.example;

import org.example.dao.MySessionFactory;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
    }
}