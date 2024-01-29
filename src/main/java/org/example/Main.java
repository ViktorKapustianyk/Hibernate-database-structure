package org.example;

import org.example.dao.EntityStoreDAO;
import org.example.entity.EntityStore;
import org.example.service.ServiceManager;
import org.example.service.MySessionFactory;
import org.example.entity.EntityCustomer;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        // Obtain SessionFactory
        SessionFactory sessionFactory = MySessionFactory.getSessionFactory();

        // Create Customer Service
        ServiceManager serviceManager = new ServiceManager(sessionFactory);

//         Create Customer with Dependencies
//        EntityCustomer createdCustomer = serviceManager.createCustomerWithDependencies();
//        System.out.println("Created Customer: " + createdCustomer);

//        serviceManager.customerReturnInventoryToStore();
//        System.out.println("Customer return inventor");

//        serviceManager.customerRentInventory();
//        System.out.println("Customer rent Film");

        serviceManager.madeNewFilm();
        System.out.println("Production has made new Film");

//        EntityStoreDAO entityStoreDAO = new EntityStoreDAO(sessionFactory);
//        EntityStore store = entityStoreDAO.getFirstStore();
//        System.out.println("First store: " + store);
    }
}
