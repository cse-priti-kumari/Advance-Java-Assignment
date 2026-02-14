package EmployeeNest;

import jakarta.persistence.*;
import java.util.*;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("dept-unit");

        EntityManager em = emf.createEntityManager();

        try {

            // Create Employees
            Employee e1 = new Employee();
            e1.setName("Priti");
            e1.setDesignation("Developer");
            e1.setSalary(50000);

            Employee e2 = new Employee();
            e2.setName("Ritika");
            e2.setDesignation("Tester");
            e2.setSalary(40000);

            Employee e3 = new Employee();
            e3.setName("Soumi");
            e3.setDesignation("HR");
            e3.setSalary(45000);

            // Create Department
            Department dept = new Department();
            dept.setName("IT");
            dept.setLocation("Bangalore");

            List<Employee> empList = new ArrayList<>();
            empList.add(e1);
            empList.add(e2);
            empList.add(e3);

            dept.setEmployees(empList);

            // Save
            em.getTransaction().begin();
            em.persist(dept);  // cascade saves employees
            em.getTransaction().commit();

            System.out.println("Department and Employees saved!");

            // Fetch Department
            Department fetchedDept =
                    em.find(Department.class, dept.getId());

            System.out.println("Department: " + fetchedDept.getName());

            for (Employee emp : fetchedDept.getEmployees()) {
                System.out.println(emp.getName() + " - " + emp.getDesignation());
            }

        } finally {
            em.close();
            emf.close();
        }
    }
}
