package com.capgemini.hibernate.HibernateDemo2;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String city;
    private String state;
    private String country;

    // 🔹 DEFAULT CONSTRUCTOR (MANDATORY)
    public Address() {}

    // 🔹 Parameterized constructor
    public Address(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    // Getters & Setters
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
}
