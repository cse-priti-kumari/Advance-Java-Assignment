package EmployeeAndLockerUniOneToOne;


import jakarta.persistence.*;

@Entity
@Table(name = "lockers")
public class Locker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lockerId;

    private String lockerNumber;

    private String floor;

    // Getters and Setters

    public int getLockerId() {
        return lockerId;
    }

    public void setLockerId(int lockerId) {
        this.lockerId = lockerId;
    }

    public String getLockerNumber() {
        return lockerNumber;
    }

    public void setLockerNumber(String lockerNumber) {
        this.lockerNumber = lockerNumber;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }
}
