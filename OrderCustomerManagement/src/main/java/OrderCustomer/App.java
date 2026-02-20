package OrderCustomer;

import jakarta.persistence.*;
import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        // 1️⃣ EntityManagerFactory create
        EntityManagerFactory emf =
                Persistence.createEntityManagerFasctory("OrderCustomerPU");

        // 2️⃣ EntityManager create
        EntityManager em = emf.createEntityManager();

        // 3️⃣ Transaction start
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // 4️⃣ Create Customer
        Customer customer = new Customer("Priti", "priti@gmail.com");
        em.persist(customer);

        // 5️⃣ Create multiple Orders for same Customer
        Order order1 = new Order(LocalDate.now(), 5000, customer);
        Order order2 = new Order(LocalDate.now(), 8000, customer);

        em.persist(order1);
        em.persist(order2);

        // 6️⃣ Commit transaction
        tx.commit();

        // 7️⃣ Retrieve Order and show Customer details
        Order foundOrder = em.find(Order.class, 1);

        System.out.println("Order Amount: " + foundOrder.getTotalAmount());
        System.out.println("Customer Name: " +
                foundOrder.getCustomer().getCustomerName());

        // 8️⃣ Close
        em.close();
        emf.close();
        
        System.out.println("Data Inserted Successfully");
    }
}

