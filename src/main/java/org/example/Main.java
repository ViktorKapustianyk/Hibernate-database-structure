package org.example;

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

        // Create Customer with Dependencies
//        EntityCustomer createdCustomer = serviceManager.createCustomerWithDependencies();
//        // Use the Created Customer
//        System.out.println("Created Customer: " + createdCustomer);

        serviceManager.customerReturnInventoryToStore();
        System.out.println("Customer return inventor");
    }
}
