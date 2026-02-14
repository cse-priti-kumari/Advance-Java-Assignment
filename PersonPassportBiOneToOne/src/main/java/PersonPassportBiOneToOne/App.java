package PersonPassportBiOneToOne;

import jakarta.persistence.*;
import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("passport-unit");

        EntityManager em = emf.createEntityManager();

        try {

            // Create Person
            Person person = new Person();
            person.setName("Amit Sharma");
            person.setDateOfBirth(LocalDate.of(1995, 5, 10));

            // Create Passport
            Passport passport = new Passport();
            passport.setPassportNumber("IND123456");
            passport.setIssueDate(LocalDate.now());
            passport.setExpiryDate(LocalDate.now().plusYears(10));

            // Link both sides (VERY IMPORTANT)
            passport.setPerson(person);
            person.setPassport(passport);

            em.getTransaction().begin();
            em.persist(passport);   // Owning side persist
            em.getTransaction().commit();

            System.out.println("Person and Passport saved successfully!");

            // Fetch Passport from Person
            Person fetchedPerson =
                    em.find(Person.class, person.getPersonId());

            System.out.println("Passport Number: "
                    + fetchedPerson.getPassport().getPassportNumber());

            // Fetch Person from Passport
            Passport fetchedPassport =
                    em.find(Passport.class, passport.getPassportId());

            System.out.println("Person Name: "
                    + fetchedPassport.getPerson().getName());

        } finally {
            em.close();
            emf.close();
        }
    }
}
