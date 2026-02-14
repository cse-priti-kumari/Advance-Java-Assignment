package EmployeeAndLockerUniOneToOne;


import jakarta.persistence.*;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("employee-unit");

        EntityManager em = emf.createEntityManager();

        try {

            // Create Locker
            Locker locker = new Locker();
            locker.setLockerNumber("L-101");
            locker.setFloor("1st Floor");

            // Create Employee
            Employee emp = new Employee();
            emp.setName("Rahul");
            emp.setDepartment("IT");

            // Assign Locker
            emp.setLocker(locker);

            // Save to DB
            em.getTransaction().begin();
            em.persist(emp);
            em.getTransaction().commit();

            System.out.println("Employee and Locker saved successfully!");

            // Fetch
            Employee fetched =
                    em.find(Employee.class, emp.getEmployeeId());

            System.out.println("Employee Name: " + fetched.getName());
            System.out.println("Department: " + fetched.getDepartment());
            System.out.println("Locker Number: "
                    + fetched.getLocker().getLockerNumber());

        } finally {
            em.close();
            emf.close();
        }
    }
}

