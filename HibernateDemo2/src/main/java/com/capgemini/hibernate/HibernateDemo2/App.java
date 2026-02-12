package com.capgemini.hibernate.HibernateDemo2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("myPersistenceUnit");

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // -------------------------------
            // CUSTOMER CRUD
            // -------------------------------

            Customer newCustomer =
                new Customer(200, "Ritika", "Punjab");

            em.persist(newCustomer);

            Customer foundCustomer =
                em.find(Customer.class, 200);

            System.out.println("Found Customer: " + foundCustomer);

            // -------------------------------
            // EMPLOYEE + ADDRESS (Embedded)
            // -------------------------------

            Address addr =
                new Address("Delhi", "Delhi", "India");

            Employee emp =
                new Employee(1, "Ritika Employee", addr);

            em.persist(emp);

            em.getTransaction().commit();

            System.out.println("Data Inserted Successfully ✅");

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}