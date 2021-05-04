package com.example.vehicletickets;

import java.util.List;

public class Users {

    private String name;
    private String surname;
    private String email;
    private String country;
    private long numberOfFlies;
    private long bonus ;
    private List<String> flights;
    private CreditCard creditCardInfo;

    public Users() {
    }

    public Users(String name, String surname, String email, String country, long numberOfFlies, long bonus, List<String> flights, CreditCard creditCardInfo) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.country = country;
        this.numberOfFlies = numberOfFlies;
        this.bonus = bonus;
        this.flights = flights;
        this.creditCardInfo = creditCardInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getNumberOfFlies() {
        return numberOfFlies;
    }

    public void setNumberOfFlies(long numberOfFlies) {
        this.numberOfFlies = numberOfFlies;
    }

    public long getBonus() {
        return bonus;
    }

    public void setBonus(long bonus) {
        this.bonus = bonus;
    }

    public List<String> getFlights() {
        return flights;
    }

    public void setFlights(List<String> flights) {
        this.flights = flights;
    }

    public CreditCard getCreditCardInfo() {
        return creditCardInfo;
    }

    public void setCreditCardInfo(CreditCard creditCardInfo) {
        this.creditCardInfo = creditCardInfo;
    }
}
