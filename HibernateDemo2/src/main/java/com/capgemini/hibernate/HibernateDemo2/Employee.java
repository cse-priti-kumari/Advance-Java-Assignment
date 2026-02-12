package com.capgemini.hibernate.HibernateDemo2;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    private int id;
    private String name;

    @Embedded
    private Address address;

    // 🔹 DEFAULT CONSTRUCTOR (MANDATORY)
    public Employee() {}

    public Employee(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}