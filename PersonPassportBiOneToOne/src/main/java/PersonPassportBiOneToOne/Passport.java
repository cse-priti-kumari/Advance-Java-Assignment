package PersonPassportBiOneToOne;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "passports")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int passportId;

    private String passportNumber;

    private LocalDate issueDate;

    private LocalDate expiryDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", unique = true, nullable = false)
    private Person person;


    // Getters and Setters

    public int getPassportId() {
        return passportId;
    }

    public void setPassportId(int passportId) {
        this.passportId = passportId;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

